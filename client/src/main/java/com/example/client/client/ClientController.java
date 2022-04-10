package com.example.client.client;


//import com.example.server.account.AccountDto;
import com.example.demo.dto.AccountView;
import com.example.server.account.Account;
import com.example.server.account.AccountDto;
import com.example.server.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Value("http://localhost:8083")
    private String url;

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    private ClientService clientService;

    @GetMapping("/client-start")
    public String getStarted() {
        return "Client is ready.";
    }

    @GetMapping("/get")
    public AccountDto get()
    {
       return restTemplate.getForObject(url + "/account/find", AccountDto.class);
    }


}