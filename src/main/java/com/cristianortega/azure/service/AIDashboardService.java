package com.cristianortega.azure.service;

import com.cristianortega.azure.domain.dto.Interaction;
import com.cristianortega.azure.domain.exception.AIException;
import com.cristianortega.azure.domain.variable.MessageCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AIDashboardService {
	public Optional<List<Interaction>> listInteractions(String conversationId) {
		// TODO completar

		if (!validate()) {
			throw new AIException(MessageCode.AZURE_CONNEXION_ERROR, HttpStatus.BAD_GATEWAY.value());
		}

		List<Interaction> data = new ArrayList<Interaction>();

		return Optional.of(data);
	}

	public boolean validate() {
		// TODO completar

		return false;
	}

}
