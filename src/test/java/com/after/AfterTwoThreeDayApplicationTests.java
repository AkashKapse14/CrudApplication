package com.after;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.after.dao.AfDao;
import com.after.model.AfModel;

      

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AfterTwoThreeDayApplicationTests {

	@Autowired
	AfDao afDao;
	
	//this is for test create
	@Test
	@Order(1)
	public void testCreate()
	{
		AfModel af=new AfModel();
		af.setId(202);
		af.setName("arya");
		af.setEmail("arayakapse@gmail.com");
		af.setPhone("13");
		af.setGender("male");
		af.setCity("Nagpur");
		af.setAddress("hingna Road");
		
		afDao.save(af);
		assertNotNull(afDao.findById(205).get());
	}
//	
	//this is get all id
	
	@Test
	@Order(2)
	public void testGetAll()
	{
		
		List<AfModel> findAll = afDao.findAll();
		assertThat(findAll).size().isGreaterThan(0);
	}
	//get Single Record
	@Test
	@Order(3)
	public void getSingleUser()
	{
		AfModel afModel = afDao.findById(205).get();
		assertEquals(205, afModel.getId());
	}
	
	//update recorad
	@Test
	@Order(4)
	public void testUpdate()
	{
		AfModel model = afDao.findById(205).get();
		model.setPhone("9922093340");
		afDao.save(model);
		assertNotEquals("13", afDao.findById(205).get().getPhone());
	}
	
	//delete record
	
	@Test
	@Order(5)
	public void testDelete()
	{
		afDao.deleteById(205);
		assertThat(afDao.existsById(202)).isFalse();
	}
}
