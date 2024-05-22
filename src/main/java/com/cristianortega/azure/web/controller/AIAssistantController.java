package com.cristianortega.azure.web.controller;

import com.cristianortega.azure.domain.dto.ApiResponse;
import com.cristianortega.azure.domain.dto.Action;
import com.cristianortega.azure.service.AIAssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia-service")
public class AIAssistantController {

    private final AIAssistantService aIAssistantService;
    private final MessageSource messageSource;

    @Autowired
    public AIAssistantController(AIAssistantService aIAssistantService, MessageSource messageSource) {
        this.aIAssistantService = aIAssistantService;
        this.messageSource = messageSource;
    }

    @PostMapping("/action")
    public ResponseEntity<ApiResponse<Action>> save(@RequestBody Action action) {
       return this.aIAssistantService.doTask(action)
                    .map(aboutSaved ->
                            new ResponseEntity<>(ApiResponse.success(HttpStatus.CREATED.value(), "Se ha realizado la operación con éxito", aboutSaved, messageSource), HttpStatus.CREATED)
                    ).orElse(
                            new ResponseEntity<>(ApiResponse.error(HttpStatus.BAD_REQUEST.value(), "Hubo un error al realidad la operación enviada", null, messageSource), HttpStatus.BAD_REQUEST)
                    );
    }

    @PostMapping("/end")
    public ResponseEntity<ApiResponse<Void>> endConversation() {
        this.aIAssistantService.endConversation();
        ApiResponse<Void> response = ApiResponse.success(HttpStatus.OK.value(), "operation.successful", null, messageSource);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}