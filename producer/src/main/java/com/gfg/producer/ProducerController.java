package com.gfg.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProducerController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping(value = "/produce")
    public ResponseEntity<Boolean> produce(@RequestBody MyMsg myMsg) {
        try {
            kafkaProducerService.send("topic-name", myMsg);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception ex) {
            return ResponseEntity.ok(Boolean.FALSE);
        }
    }
}
