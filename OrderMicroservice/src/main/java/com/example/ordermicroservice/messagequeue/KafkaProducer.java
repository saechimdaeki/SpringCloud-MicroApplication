package com.example.ordermicroservice.messagequeue;

import com.example.ordermicroservice.dto.OrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public OrderDto send(String topic, OrderDto orderDto){
        ObjectMapper mapper=new ObjectMapper();
        String jsonInString ="";

        try{
            jsonInString=mapper.writeValueAsString(orderDto);
        }catch (JsonProcessingException ex){
            ex.printStackTrace();
        }
        kafkaTemplate.send(topic,jsonInString);
        log.debug("\n Kafka Producer sent data from the Order microservice {}",orderDto);

        return orderDto;
    }
}
