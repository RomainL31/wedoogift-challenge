package com.rle.wedoogift.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rle.wedoogift.deposit.Deposit;
import com.rle.wedoogift.utils.DistributionUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompanyServiceTest {

    @Autowired
    CompanyService companyService;

    Company richCompany;
    Company poorCompany;

    List<Deposit> depositList;

    Company richCompanyExpected;
    Company poorCompanyExpected;

    @BeforeAll

    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // get companies input
             richCompany = objectMapper.readValue(new File("src/test/resources/stubs/inputs/richCompanyInput.json"), Company.class);
             poorCompany = objectMapper.readValue(new File("src/test/resources/stubs/inputs/poorCompanyInput.json"), Company.class);

            // get deposits input
            JSONObject jsonObject = new JSONObject(Files.readString(Paths.get("src/test/resources/stubs/inputs/depositsInput.json")));
            JSONArray jsonArray = jsonObject.getJSONArray("deposits");

            depositList = objectMapper.readValue(String.valueOf(jsonArray), new TypeReference<List<Deposit>>(){});

            // get companies output
            richCompanyExpected = objectMapper.readValue(new File("src/test/resources/stubs/outputs/richCompanyOutput.json"), Company.class);
            poorCompanyExpected = objectMapper.readValue(new File("src/test/resources/stubs/outputs/poorCompanyOutput.json"), Company.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void distributeDepositRichCompany() {
        // test distribution of deposit
       companyService.distributeDeposit(richCompany, depositList);

        // assert equals success
        assertThat(richCompany)
                .usingRecursiveComparison()
                .isEqualTo(richCompanyExpected);
    }

    @Test
    void distributeDepositPoorCompany() {
        // test distribution of depostis
        companyService.distributeDeposit(poorCompany, depositList);

        // assert equals success
        assertThat(poorCompany)
                .usingRecursiveComparison()
                .isNotEqualTo(poorCompanyExpected);
        // assert equals failure
    }
}