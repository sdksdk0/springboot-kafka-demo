package cn.tf.kafka.controller;

import cn.tf.kafka.entity.Message;
import cn.tf.kafka.producer.KafkaProducer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class IndexController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/sendInfo")
    public void sendInfo(){
        kafkaProducer.send();
    }


}

