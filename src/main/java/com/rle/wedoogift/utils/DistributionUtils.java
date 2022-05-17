package com.rle.wedoogift.utils;

import com.rle.wedoogift.deposit.Deposit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class DistributionUtils {

    public List<Deposit> cleanDeposits(List<Deposit> depositList) {
        List<Deposit> cleanList = new ArrayList<>();

        for (int i = 0; i != depositList.size(); i++) {
            if (isDepositExpired(depositList.get(i).getDateOfExpiration()))
                 cleanList.add(depositList.get(i));
        }

        return cleanList;
    }

    public float calculateBalance(List<Deposit> depositList) {
        int totalDepositValue = 0;

        for (int i = 0; i != depositList.size(); i++) {
            totalDepositValue += depositList.get(i).getValue();
        }

        return (totalDepositValue);
    }

    public boolean isDepositExpired(Date expirationDate) {
        Date today = new Date();

        return (expirationDate.after(today));
    }
}
