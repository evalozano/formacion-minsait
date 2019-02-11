package com.paradigma.arrival.transformer;

import com.paradigma.arrival.controller.rdto.response.ArrivalRSDTO;
import com.paradigma.arrival.service.dto.response.ArrivalODTO;

public interface ArrivalTransformer {

	ArrivalRSDTO toRSRDTO(ArrivalODTO arrivalODTO);

}
