package com.cristianortega.azure.web.controller;

import com.cristianortega.azure.domain.dto.ApiResponse;
import com.cristianortega.azure.domain.dto.Interaction;
import com.cristianortega.azure.service.AIDashboardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia-dashboard")
public class AIDashboardController {

	private final AIDashboardService aIDashboardService;
	private final MessageSource messageSource;

	@Autowired
	public AIDashboardController(AIDashboardService aIDashboardService, MessageSource messageSource) {
		this.aIDashboardService = aIDashboardService;
		this.messageSource = messageSource;
	}

	@GetMapping("/status")
	public ResponseEntity<ApiResponse<Void>> status() {
		ApiResponse<Void> response = ApiResponse.success(HttpStatus.OK.value(), "ia-dashboard OK", null, messageSource);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/interactions/list/{conversationId}")
	public ResponseEntity<ApiResponse<List<Interaction>>> listInteractions(
			@PathVariable(name = "conversationId") String conversationId) {
		return this.aIDashboardService.listInteractions(conversationId)
				.map(data -> new ResponseEntity<>(ApiResponse.success(HttpStatus.OK.value(),
						"Se ha realizado la operación con éxito", data, messageSource), HttpStatus.OK))
				.orElse(new ResponseEntity<>(
						ApiResponse.error(HttpStatus.BAD_REQUEST.value(),
								"Hubo un error al realidar la operación enviada", null, messageSource),
						HttpStatus.BAD_REQUEST));
	}

}