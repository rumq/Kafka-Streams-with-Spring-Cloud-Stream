package guru.learningjournal.examples.kafka.avroposfanout;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvroPosFanoutApplication implements ApplicationRunner {


	public static void main(String[] args) {
		SpringApplication.run(AvroPosFanoutApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		while(true) {
			Thread.sleep(1000);
		}
	}


}
