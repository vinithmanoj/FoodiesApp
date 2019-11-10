package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Hotel;
import com.spring.model.Menu;
import com.spring.service.FoodyService;

@RestController
public class FoodAppController {

	@Autowired
	private FoodyService foodyService;

	@GetMapping("/hotels")
	public ResponseEntity<?> getHotels() {

		List<Hotel> hotelList = foodyService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotelList,HttpStatus.OK);

	}

	@PostMapping("/hotels")
	public ResponseEntity<?> save(@RequestBody Hotel hotel) {
		// creation logic
		hotel.setId(foodyService.save(hotel));
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@PostMapping("/hotels/{id}/menu")
	public ResponseEntity<?> saveMenu(@PathVariable Long id,
			@RequestBody Menu menu) {
		// creation logic
		menu = foodyService.saveMenu(id, menu);
		// return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}
}