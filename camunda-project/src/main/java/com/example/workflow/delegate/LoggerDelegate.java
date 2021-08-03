package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoggerDelegate implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("\n ... LoggerDelegate invoked by " +
                "\n getProcessDefinitionId " + delegateExecution.getProcessDefinitionId() +
                "\n getCurrentActivityId " + delegateExecution.getCurrentActivityId() +
                "\n getCurrentActivityName " + delegateExecution.getCurrentActivityName() +
                "\n getProcessInstanceId " + delegateExecution.getProcessInstanceId() +
                "\n getProcessBusinessKey " + delegateExecution.getProcessBusinessKey() +
                "\n getId " + delegateExecution.getId()
        );
    }
}
