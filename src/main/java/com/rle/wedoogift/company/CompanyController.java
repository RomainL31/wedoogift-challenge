package com.rle.wedoogift.company;

import com.rle.wedoogift.deposit.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @GetMapping
    public boolean distributeDeposit(Company company, List<Deposit> depositList)  {
        return companyService.distributeDeposit(company, depositList);
    }
}
