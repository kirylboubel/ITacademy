package by.itacademy.service.impl;

import by.itacademy.advice.annotation.ExecutionTime;
import by.itacademy.service.Service;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @ExecutionTime
    @Override
    public int smallService(int a, int b) {
        return a + b;
    }
    @ExecutionTime
    @Override
    public int bigService(int a, int b, int c) {
        return (a + b) * c;
    }
}
