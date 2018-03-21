package com.johnnyrichard.todo;

import com.johnnyrichard.todo.query.converter.TodoIdConverters;
import com.mongodb.MongoClient;
import lombok.AllArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class TodoApplication {

    private AmqpAdmin admin;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class);
    }

    @Bean
    public EventStorageEngine eventStorageEngine(MongoClient client) {
        return new MongoEventStorageEngine(new DefaultMongoTemplate(client));
    }

    @Bean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converters = List.of(TodoIdConverters.reading(), TodoIdConverters.writing());
        return new CustomConversions(converters);
    }

    @Bean
    public Exchange exchange(@Value("${axon.amqp.exchange}") String name) {
        Exchange exchange = ExchangeBuilder.fanoutExchange(name).build();
        admin.declareExchange(exchange);
        return exchange;
    }

    @Bean
    public Binding binding(Exchange exchange, Queue queue) {
        Binding binding = BindingBuilder.bind(queue).to(exchange).with("*").noargs();
        admin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Queue queue() {
        Queue queue = QueueBuilder.durable("TodoEvents").build();
        admin.declareQueue(queue);
        return queue;
    }
}
