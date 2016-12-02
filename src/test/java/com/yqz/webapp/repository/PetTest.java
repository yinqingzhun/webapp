package com.yqz.webapp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.*;

import com.yqz.webapp.dto.Pet;
import com.yqz.webapp.mapper.PetMapper;

public class PetTest {
	private static SqlSessionFactory factory = null;

	@BeforeClass
	public static void init() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void selectPetById() {
		SqlSession session = factory.openSession();
		try {
			PetMapper mapper = session.getMapper(PetMapper.class);
			Pet result = mapper.selectByPrimaryKey(3);
			assertNotNull(result);
			assertEquals((int) result.getPetId(), 3);

		} finally {
			session.close();
		}

	}

	@Test
	public void insert() {
		SqlSession session = factory.openSession();
		try {
			PetMapper mapper = session.getMapper(PetMapper.class);
			Pet pet = new Pet();
			pet.setCreateTime(new Date());
			pet.setOwnerId(1);
			pet.setPetName("Rose");
			pet.setPetType(2);
			int count = mapper.insert(pet);
			session.commit();
			System.out.println("id:" + pet.getPetId());
			assertTrue(count == 1);

		} finally {
			session.close();
		}
	}

	@Test
	public void update() {
		SqlSession session = factory.openSession();
		try {
			PetMapper mapper = session.getMapper(PetMapper.class);
			Pet pet = new Pet();
			pet.setCreateTime(new Date());
			pet.setOwnerId(1);
			pet.setPetName("大师");
			pet.setPetType(2);
			pet.setPetId(3);
			int count = mapper.updateByPrimaryKey(pet);
			session.commit();
			assertTrue(count == 1);

		} finally {
			session.close();
		}
	}

}
