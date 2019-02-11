package com.paradigma.arrival.transformer.impl;

import org.springframework.stereotype.Component;

import com.paradigma.arrival.controller.rdto.response.ArrivalRSDTO;
import com.paradigma.arrival.service.dto.response.ArrivalODTO;
import com.paradigma.arrival.transformer.ArrivalTransformer;

@Component
public class ArrivalTransformerImpl implements ArrivalTransformer {

	@Override
	public ArrivalRSDTO toRSRDTO(ArrivalODTO arrivalODTO) {
		ArrivalRSDTO response = new ArrivalRSDTO();

		response.setCity(arrivalODTO.getCity());
		response.setId(arrivalODTO.getId());

		return response;
	}

}
