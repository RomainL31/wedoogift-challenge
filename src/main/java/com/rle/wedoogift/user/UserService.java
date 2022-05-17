package com.rle.wedoogift.user;

import com.rle.wedoogift.deposit.Deposit;
import com.rle.wedoogift.utils.DistributionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final DistributionUtils distributionUtils;

    @Autowired
    public UserService(DistributionUtils distributionUtils) {
        this.distributionUtils = distributionUtils;
    }

    public float getBalance(User user) {
        List<Deposit> userCleanDeposits = distributionUtils.cleanDeposits(user.getWallet());

        return user.getAccount() + distributionUtils.calculateBalance(userCleanDeposits);
    }
}
