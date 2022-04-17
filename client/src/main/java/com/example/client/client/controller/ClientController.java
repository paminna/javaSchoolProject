package com.example.client.client.controller;
import ch.qos.logback.core.status.Status;
import com.example.client.client.ClientRequest;
import com.example.server.controller.PersonController;
import com.example.server.dto.AccountDto;
import com.example.server.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Value("http://localhost:8083")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client-start")
    public String getStarted() {
        return "Client is ready.";
    }

    @PostMapping("/get/accounts/by")
    public List<AccountDto> getAccountById(@RequestBody ClientRequest request)
    {
        AccountDto[] responses =
                restTemplate.postForObject(url + "/account/get-accounts-by", request, AccountDto[].class);
        List<AccountDto> list = Arrays.asList(responses);
        return list;
    }

}