package com.carservice.storecarjava11.message;

import com.carservice.storecarjava11.dto.CarPostDto;
import com.carservice.storecarjava11.service.CarPostService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = (Logger) LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts_group")
    public void listening(CarPostDto carPost) {

        LOG.info("Received Car Post Information: {}");
        carPostService.newPostDetails(carPost);
    }
}
