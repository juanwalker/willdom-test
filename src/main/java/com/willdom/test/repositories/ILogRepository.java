package com.willdom.test.repositories;

import model.LogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILogRepository extends CrudRepository<LogEntry,Integer> {
}
