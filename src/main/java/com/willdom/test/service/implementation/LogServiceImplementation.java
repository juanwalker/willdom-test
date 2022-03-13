package com.willdom.test.service.implementation;
import com.willdom.test.repositories.ILogRepository;
import com.willdom.test.service.ILogService;
import lombok.extern.slf4j.Slf4j;
import model.LogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
@Slf4j
@Service
public class LogServiceImplementation implements ILogService {
    private ILogRepository logRepository;
    public LogServiceImplementation(@Autowired ILogRepository logRepository){
        this.logRepository = logRepository;
    }
    @Override
    public void doLogEntry(String message, String... params) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(String.format(message,params));
        logEntry.setException(null);
        logEntry.setTimestamp(new Date());
        log.info(logEntry.getMessage());
        this.logRepository.save(logEntry);
    }
    @Override
    public void doLogEntry(Throwable exception) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(exception.getMessage());
        logEntry.setException(Arrays.toString(exception.getStackTrace()));
        logEntry.setTimestamp(new Date());
        log.info(logEntry.getMessage());
        log.info(logEntry.getException());
        this.logRepository.save(logEntry);
    }
}

