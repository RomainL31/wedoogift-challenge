package com.rle.wedoogift.company;

import com.rle.wedoogift.deposit.Deposit;
import com.rle.wedoogift.utils.DistributionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    public boolean distributeDeposit(Company company, List<Deposit> depositList) {
        DistributionUtils distributionUtils = new DistributionUtils();
        float newBalance = distributionUtils.calculateBalance(depositList);

        if (newBalance > 0) {
            company.setAccount(company.getAccount() - newBalance);
            return true;
        }
        return false;
    }
}
