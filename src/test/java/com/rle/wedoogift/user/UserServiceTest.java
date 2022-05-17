package com.rle.wedoogift.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rle.wedoogift.company.Company;
import com.rle.wedoogift.company.CompanyService;
import com.rle.wedoogift.deposit.Deposit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 @SpringBootTest
 @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {
    @Autowired
    UserService userService;

    private User user;
    private User userExpected;


    @BeforeAll
    public void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        user = objectMapper.readValue(new File("src/test/resources/stubs/inputs/userInput.json"), User.class);
        userExpected = objectMapper.readValue(new File("src/test/resources/stubs/outputs/userOutput.json"), User.class);
    }

    @Test
    void checkBalance() {
        // distribute deposit
        float  balance = userService.getBalance(user);
        float balanceExpected = userService.getBalance(userExpected);

        // assert input equals output
        assertEquals(balance, balanceExpected);
    }

}