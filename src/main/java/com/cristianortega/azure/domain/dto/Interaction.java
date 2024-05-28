package com.cristianortega.azure.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Interaction {

	public String request;
	public String response;
	public String dateTime;

}
