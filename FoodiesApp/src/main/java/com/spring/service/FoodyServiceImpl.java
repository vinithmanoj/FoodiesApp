package com.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.FoodyDao;
import com.spring.model.Hotel;
import com.spring.model.Menu;



@Service
@Transactional(readOnly=true)
public class FoodyServiceImpl implements FoodyService{
	
	@Autowired
	private FoodyDao foodyDao;

	@Override
	@Transactional
	public long save(Hotel hotel) {
		return foodyDao.save(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotels() {
		return foodyDao.getAllHotels();
	}

	@Override
	@Transactional
	public Menu saveMenu(long hotelId, Menu menu) {
		Hotel hotel = foodyDao.getHotel(hotelId);
		hotel.addMenu(menu);
		menu = foodyDao.saveMenu(menu);
		return menu;
	}

}
