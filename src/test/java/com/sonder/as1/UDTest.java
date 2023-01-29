package com.sonder.as1;

import com.sonder.as1.entity.Donation;
import com.sonder.as1.entity.User;
import com.sonder.as1.entity.UserDonation;
import com.sonder.as1.services.DonationService;
import com.sonder.as1.services.UserDonationService;
import com.sonder.as1.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class UDTest {
    @Autowired
    public UserService userService;
    @Autowired
    public UserDonationService userDonationService;
    @Autowired
    public DonationService donationService;

    @Test
    public void createUD_test() {
        UserDonation $ = new UserDonation();
        $.setName("Canh bao ret dam ret hai mien trung");
        $.setMoney(90000L);
        $.setText("Ret dam ret hai co the xuong duoi 10 do c");
        userDonationService.createEntity($,1,1);
    }

}
