package org.example.springapachekafka.config;

import org.example.springapachekafka.model.ExchangeRatesDTO;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    ConsumerFactory<String, ExchangeRatesDTO> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(null));
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, ExchangeRatesDTO> kafkaContainerFactory(ConsumerFactory<String, ExchangeRatesDTO> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, ExchangeRatesDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);

        return factory;
    }
}
