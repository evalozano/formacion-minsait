package com.paradigma.cucumber.controller.arrival;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.cucumber.controller.arrival.rdto.response.ArrivalRSDTO;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RestController
public class ArrivalController {

	private Map<Integer, ArrivalRSDTO> arrivals;

	@RequestMapping(method={RequestMethod.GET},value={"/arrival/all"})
	@ResponseBody
	public List<ArrivalRSDTO> getAllArrivals() {

		return arrivals.values().stream().collect(Collectors.toList());
	}

	@RequestMapping(value = "/arrival/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<ArrivalRSDTO> getArrivalById(@PathVariable(value = "id") int id) {

		Optional<ArrivalRSDTO> arrival = arrivals.entrySet().stream().filter(e -> e.getKey() == id)
				.map(Map.Entry::getValue).findFirst();

		if (arrival.isPresent()) {
			return new ResponseEntity<>(arrival.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostConstruct
	public void fillArrivals() {
		arrivals = new HashMap<>();
		PodamFactory factory = new PodamFactoryImpl();

		ArrivalRSDTO firstArrival = factory.manufacturePojo(ArrivalRSDTO.class);
		ArrivalRSDTO secondArrival = factory.manufacturePojo(ArrivalRSDTO.class);
		ArrivalRSDTO thirthArrival = factory.manufacturePojo(ArrivalRSDTO.class);

		arrivals.put(0, firstArrival);
		arrivals.put(1, secondArrival);
		arrivals.put(2, thirthArrival);

	}
}
