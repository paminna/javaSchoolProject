package com.example.client.client;


//import com.example.server.account.AccountDto;
import com.example.demo.dto.AccountView;
import com.example.server.account.AccountDto;
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
    RestTemplate restTemplate;

    @GetMapping("/client-start")
    public String getStarted() {
        return "Client is ready.";
    }

    @GetMapping("/get/accounts/by/{id}")
    public List<AccountDto> getAccountById(@PathVariable("id") String personId)
    {
//        String tmp = url + "/get-accounts-by/" + personId;
//        AccountView res = restTemplate.getForObject(url + "/account/get-accounts-by/" + personId, AccountView.class);
        AccountDto[] responses =
                restTemplate.getForObject(url + "/account/get-accounts-by/" + personId, AccountDto[].class );
        List<AccountDto> list = Arrays.asList(responses);
        return list;
    }

}