package net.rumq.avroemployeegen;

import net.rumq.avroemployeegen.services.KafkaProducerService;
import net.rumq.demo.kafka.model.Employee;
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
        String run = "a-";
        producerService.sendMessage(createEmployee(run + "1111", "Anand", "Audio", 1111));
        producerService.sendMessage(createEmployee(run + "2222", "Bacchan", "Brand", 2222));
        producerService.sendMessage(createEmployee(run + "3333", "Chand", "Channel", 3333));


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
