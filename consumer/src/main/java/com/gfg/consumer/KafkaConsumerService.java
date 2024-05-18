package com.gfg.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = {"topic-name"}, groupId = "topic-name")
    public void consume(MyMsg myMsg) {
        log.info(String.format("Received: " + myMsg));
    }
}
