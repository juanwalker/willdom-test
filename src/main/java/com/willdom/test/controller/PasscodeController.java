package com.willdom.test.controller;

import com.willdom.test.service.ILogService;
import com.willdom.test.service.IPasscodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController("/")
public class PasscodeController {

    @Autowired
    IPasscodeService passcodeService;

    @Autowired
    ILogService logService;

    public PasscodeController(IPasscodeService passcodeService, ILogService logService) {
        this.passcodeService = passcodeService;
        this.logService = logService;
    }

    @GetMapping("/{id}")
    public String [] getPassCodeArray(@PathVariable("id") String strValue){
        logService.doLogEntry("/%s was called",strValue);
        String[] passcodeArray = this.passcodeService.getPasscodeArray(Integer.valueOf(strValue));
        logService.doLogEntry("/%s returned", Arrays.toString(passcodeArray));
        return passcodeArray;
    }


}
