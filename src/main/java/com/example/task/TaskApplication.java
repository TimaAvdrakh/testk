package com.example.task;

import com.example.task.entities.Client;
import com.example.task.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository){
		return args -> {
			Client client = new Client();
			client.setIin("938838383838");
			client.setFirstName("baur");
			client.setLastName("baurzbahov");
			clientRepository.save(client);

			Client client1 = new Client();
			client1.setIin("9388383838228");
			client1.setFirstName("ban");
			client1.setLastName("tuler");
			clientRepository.save(client1);

		};
	}
}
