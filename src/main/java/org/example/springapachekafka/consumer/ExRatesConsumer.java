package org.example.springapachekafka.consumer;

import org.example.springapachekafka.model.ExchangeRatesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class ExRatesConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExRatesConsumer.class);

    @KafkaListener(
            topics = "exchange_rates",
            groupId = "softuni-consumer"
    )
    public void readMessage(@Header(KafkaHeaders.RECEIVED_KEY) String key, ExchangeRatesDTO exchangeRatesDTO) {
        LOGGER.info("We have consumed ex rate with key {} and value {}.", key, exchangeRatesDTO);
    }
}
