package com.example.client;

//import com.example.client.client.ClientRepository;
import com.example.client.client.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.client"})
public class ClientApplication {

    public static void main(String[] args) {

//        ApplicationContext context =
                SpringApplication.run(ClientApplication.class, args);
//        ClientRepository clientRepository = context.getBean(ClientRepository.class);
//
//
//            System.out.println("Check connection");
//            System.out.println(clientRepository.findAllAccounts());
    }

}
