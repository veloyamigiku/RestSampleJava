package com.example.demo.controller;

import com.example.demo.bean.Logger;
import com.example.demo.repo.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class LoggerController {

    @Autowired
    LoggerRepository loggerRepository;

    @RequestMapping(value = "/logger", method = RequestMethod.GET)
    public List<Logger> getAllLogger() {
        List<Logger> list = loggerRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/logger/{id}", method = RequestMethod.GET)
    public Logger getLoggerById(@PathVariable("id") Integer id) {
        Optional<Logger> logger = loggerRepository.findById(id);
        if (logger.isEmpty()) {
            return null;
        } else {
            return logger.get();
        }
    }

    @RequestMapping(value = "/logger", method = RequestMethod.POST)
    public Logger createNewLogger(@RequestBody Logger logger) {
        Logger newLogger = loggerRepository.save(logger);
        if (newLogger != null) {
            return newLogger;
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/logger/{id}", method = RequestMethod.PUT)
    public Logger updateLoggerById(@PathVariable(value = "id") Integer id, @RequestBody Logger logger) {
        Optional<Logger> curLogger = loggerRepository.findById(id);
        if (curLogger.isEmpty()) {
            return null;
        } else {
            loggerRepository.save(logger);
            return logger;
        }
    }

    @RequestMapping(value = "/logger/{id}", method = RequestMethod.DELETE)
    public Logger deleteLoggerById(@PathVariable(value = "id") Integer id) {
        Optional<Logger> curLogger = loggerRepository.findById(id);
        if (curLogger.isEmpty()) {
            return null;
        } else {
            Logger cl = curLogger.get();
            loggerRepository.delete(cl);
            return cl;
        }
    }

}
