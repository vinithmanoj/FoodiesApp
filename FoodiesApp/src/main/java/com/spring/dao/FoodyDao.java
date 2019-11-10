package com.spring.dao;

import java.util.List;

import com.spring.model.Hotel;
import com.spring.model.Menu;


public interface FoodyDao {
	long save(com.spring.model.Hotel hotel);

	List<Hotel> getAllHotels();
	
	Hotel getHotel(long id);

	Menu saveMenu(Menu menu);
}
