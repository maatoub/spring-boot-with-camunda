package com.it.test.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class EmailConfirmation implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object candidateEmail = delegateExecution.getVariable("candidateEmail");
        System.out.println("Confirmation envoyée à " + candidateEmail.toString());
    }

}
