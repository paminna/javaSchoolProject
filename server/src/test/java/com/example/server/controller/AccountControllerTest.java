package com.example.server.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.TestInstance;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getbyId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/get-accounts-by/{login}/{password}", "ivan", "1111"))
                .andExpect(status().isOk());
    }

    @Test
    public void noSuchPerson() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.get("/account/get-accounts-by/{login}/{password}", "dana", "2345"))
                    .andExpect(status().isOk())
                    .andExpect(mvcResult -> mvcResult.getResponse().getClass().equals(null));
    }

    @Test
    public void getAllAccounts() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/account/find-all-accounts"))
                .andExpect(status().isOk());
    }
}