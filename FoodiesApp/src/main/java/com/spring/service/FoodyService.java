package com.spring.service;

import java.util.List;

import com.spring.model.Hotel;
import com.spring.model.Menu;


public interface FoodyService {
	
	long save(Hotel hotel);

	List<Hotel> getAllHotels();
	
	Menu saveMenu(long hotelId, Menu menu);

}
