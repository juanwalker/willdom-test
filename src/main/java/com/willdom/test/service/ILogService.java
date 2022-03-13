package com.willdom.test.service;

import model.LogEntry;

public interface ILogService {
    void doLogEntry(String message, String... params);
    void doLogEntry(Throwable exception);
}
