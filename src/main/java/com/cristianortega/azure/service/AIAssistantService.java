package com.cristianortega.azure.service;

import com.cristianortega.azure.domain.dto.Action;
import com.cristianortega.azure.domain.exception.AIException;
import com.cristianortega.azure.domain.variable.MessageCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AIAssistantService {
    public Optional<Action> doTask(Action action) {
        return Optional.of(action);
    }

    public void endConversation() {
        if (!validate()) {
            throw new AIException(MessageCode.AZURE_CONNEXION_ERROR, HttpStatus.BAD_GATEWAY.value());
        }
    }

    public boolean validate() {
        return false;
    }

}
