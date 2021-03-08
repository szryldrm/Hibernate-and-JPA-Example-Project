package com.javacourse.project.hibernateAndJpa;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class HibernateAndJpaApplicationTests {

	@Autowired
	private ICityService _cityService;

	@Autowired
	private MockMvc mvc;

	@Autowired
	public HibernateAndJpaApplicationTests(ICityService cityService) {
		_cityService = cityService;
	}

	@Test
	void isCitiesFilled(){
		int size = _cityService.getAll().size();
		assertThat(size).isNotEqualTo(0);
	}

	@Test
	@Transactional
	void equalCityNameById(){
		assertThat(_cityService.getById(5).getName()).isEqualTo("Amsterdam");
	}
}
