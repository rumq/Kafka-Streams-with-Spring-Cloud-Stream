package net.rumq.avroemployeegen;

import net.rumq.avroemployeegen.services.KafkaProducerService;
import guru.learningjournal.examples.kafka.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvroemployeegenApplication implements ApplicationRunner {

    @Autowired
    private KafkaProducerService producerService;


    public static void main(String[] args) {
        SpringApplication.run(AvroemployeegenApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        producerService.sendMessage(createEmployee("a", "a", "E", 1));
        producerService.sendMessage(createEmployee("b", "b", "E", 2));
        producerService.sendMessage(createEmployee("c", "c", "A", 3));
        producerService.sendMessage(createEmployee("d", "d", "A", 4));

        producerService.sendMessage(createEmployee("b", "b", "A", 2));
        producerService.sendMessage(createEmployee("d", "d", "E", 4));


    }

    private Employee createEmployee(String id, String name, String department, int salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);

        return employee;

    }
}
