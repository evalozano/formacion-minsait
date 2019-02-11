package com.paradigma.arrival.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.paradigma.arrival.service.ArrivalService;
import com.paradigma.arrival.service.dto.response.ArrivalODTO;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Service
public class ArrivalServiceImpl implements ArrivalService {

	private Map<Integer, ArrivalODTO> arrivals;

	@Override
	public List<ArrivalODTO> getAllArrivals() {
		return arrivals.values().stream().collect(Collectors.toList());

	}

	@Override
	public Optional<ArrivalODTO> getArrivalById(Integer id) {
		return arrivals.entrySet().stream().filter(e -> e.getKey() == id).map(Map.Entry::getValue).findFirst();

	}

	@PostConstruct
	public void fillArrivals() {
		arrivals = new HashMap<>();
		PodamFactory factory = new PodamFactoryImpl();

		ArrivalODTO firstArrival = factory.manufacturePojo(ArrivalODTO.class);
		ArrivalODTO secondArrival = factory.manufacturePojo(ArrivalODTO.class);
		ArrivalODTO thirthArrival = factory.manufacturePojo(ArrivalODTO.class);

		arrivals.put(0, firstArrival);
		arrivals.put(1, secondArrival);
		arrivals.put(2, thirthArrival);

	}
}
