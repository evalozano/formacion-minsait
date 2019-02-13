package com.paradigma.arrival.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.paradigma.arrival.controller.rdto.response.ArrivalRSDTO;
import com.paradigma.arrival.service.ArrivalService;
import com.paradigma.arrival.service.dto.response.ArrivalODTO;
import com.paradigma.arrival.transformer.ArrivalTransformer;

@RunWith(MockitoJUnitRunner.class)
public class ArrivalControllerTest {

	@InjectMocks
	private ArrivalController controller;
	
	@Mock
	private ArrivalService service;

	@Mock
	private ArrivalTransformer transformer;


	@Test
	public void shouldGetAllArrivals() {
		//GIVEN
		
		Mockito.when(service.getAllArrivals()).thenReturn(getAllArrivalsMock());
		ArrivalRSDTO arrivalRSDTO = Mockito.mock(ArrivalRSDTO.class);
		Mockito.when(transformer.toRSRDTO(Mockito.any(ArrivalODTO.class))).thenReturn(arrivalRSDTO);
		//WHEN
		List<ArrivalRSDTO> allArrivals = controller.getAllArrivals();
		//THEN
		Assert.assertNotNull(allArrivals);
		Mockito.verify(service).getAllArrivals();
		Mockito.verify(transformer).toRSRDTO(Mockito.any(ArrivalODTO.class));
	}


	private List<ArrivalODTO> getAllArrivalsMock() {
		List<ArrivalODTO> arrivalList = new ArrayList<>();
		
		arrivalList.add(Mockito.mock(ArrivalODTO.class));
		return arrivalList;
	}
	
}
