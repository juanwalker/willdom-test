package com.willdom.test.service.implementation;

import com.willdom.test.service.ILogService;
import com.willdom.test.service.IPasscodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.stream.IntStream;
@Service
public class PasscodeServiceImplementation implements IPasscodeService {
    private ILogService logService;
    public PasscodeServiceImplementation(@Autowired ILogService logService) {
        this.logService = logService;
    }
    @Override
    public String[] getPasscodeArray(Integer n){
            logService.doLogEntry("getPasscodeArray(%s) mathod was called",String.valueOf(n));
            String[] passCodeArray = IntStream.range(1, n + 1).mapToObj(value -> getPassCode(value)).toArray(String[]::new);
            logService.doLogEntry("getPasscodeArray(%s) returned",Arrays.toString(passCodeArray));
            return passCodeArray;
    }
    private String getPassCode(Integer value){
        StringBuilder stb= new StringBuilder();
        if (value % 3 == 0){
            stb.append("Big");
        }
        if (value % 5 == 0){
            stb.append("Bang");
        }
        if (value % 7 == 0){
            stb.append("Theory");
        }
        if (stb.length() == 0){
            return value.toString();
        } else {
            return stb.toString();
        }
    }
}
