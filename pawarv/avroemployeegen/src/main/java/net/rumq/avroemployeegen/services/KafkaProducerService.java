package net.rumq.avroemployeegen.services;

import lombok.extern.log4j.Log4j2;
import guru.learningjournal.examples.kafka.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class KafkaProducerService {
    @Value("${application.configs.topic.name}")
    private String TOPIC_NAME;

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee employee) {
        log.info(String.format("Producing Employee No : %s", employee.getId()));
        kafkaTemplate.send(TOPIC_NAME, employee.getId(), employee);


    }
}
