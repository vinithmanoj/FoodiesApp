package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Hotel;
import com.spring.model.Menu;



@Repository
public class FoodyDaoImpl implements FoodyDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Hotel hotel) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(hotel);
		return hotel.getId();
	}

	@Override
	public List<Hotel> getAllHotels() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(
				Hotel.class);
		return c.list();
	}

	@Override
	public Hotel getHotel(long id) {
		return sessionFactory.getCurrentSession().get(Hotel.class, id);
	}

	@Override
	public Menu saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menu;
	}

}
