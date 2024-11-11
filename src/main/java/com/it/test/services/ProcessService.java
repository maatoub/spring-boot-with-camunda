package com.it.test.services;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.stereotype.Service;

@Service
public class ProcessService {
    private ProcessEngine processEngine;

    public ProcessService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public void demmarerProcess() {
        processEngine.getRuntimeService()
                .startProcessInstanceByMessage("Nouveau_Besoin", "offre-1");
    }
}
