package com.javacourse.project.hibernateAndJpa.Business;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.javacourse.project.hibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;


@Service
public class CityManager implements ICityService {
	
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		cityDal.delete(city);
	}

	@Override
	public City getById(int cityId) {
		return cityDal.getById(cityId);
	}

}
