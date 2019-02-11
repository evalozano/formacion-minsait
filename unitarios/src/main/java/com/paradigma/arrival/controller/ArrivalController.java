package com.paradigma.arrival.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.arrival.controller.rdto.response.ArrivalRSDTO;
import com.paradigma.arrival.service.ArrivalService;
import com.paradigma.arrival.service.dto.response.ArrivalODTO;
import com.paradigma.arrival.transformer.ArrivalTransformer;

@RestController
public class ArrivalController {

	@Autowired
	private ArrivalService service;

	@Autowired
	private ArrivalTransformer transformer;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/arrival/all" })
	@ResponseBody
	public List<ArrivalRSDTO> getAllArrivals() {

		return service.getAllArrivals().stream().map(transformer::toRSRDTO).collect(Collectors.toList());
	}

	@RequestMapping(value = "/arrival/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ArrivalRSDTO> getArrivalById(@PathVariable(value = "id") int id) {

		Optional<ArrivalODTO> arrivalById = service.getArrivalById(id);

		if (arrivalById.isPresent()) {
			return new ResponseEntity<>(transformer.toRSRDTO(arrivalById.get()), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
