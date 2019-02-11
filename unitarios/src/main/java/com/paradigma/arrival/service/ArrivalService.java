package com.paradigma.arrival.service;

import java.util.List;
import java.util.Optional;

import com.paradigma.arrival.service.dto.response.ArrivalODTO;

public interface ArrivalService {

	List<ArrivalODTO> getAllArrivals();

	Optional<ArrivalODTO> getArrivalById(Integer id);

}
