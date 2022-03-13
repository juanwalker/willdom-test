package com.willdom.test;

import com.willdom.test.service.IPasscodeService;
import com.willdom.test.service.implementation.PasscodeServiceImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PasscodeServiceImplementationTest {
    @Autowired
    private IPasscodeService passcodeService;

    @Test
    public void test() {
        String[] array = {"1", "2", "Big", "4", "Bang", "Big", "Theory", "8", "Big", "Bang", "11", "Big","13", "Theory", "BigBang", "16", "17", "Big", "19", "Bang", "BigTheory"};
        String[] passcodeArray = passcodeService.getPasscodeArray(21);
        assertArrayEquals(array,passcodeArray);
    }

}
