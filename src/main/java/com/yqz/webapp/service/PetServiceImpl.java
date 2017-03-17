package com.yqz.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yqz.webapp.dto.ChatMessageDetailVO;
import com.yqz.webapp.dto.Pet;
import com.yqz.webapp.mapper.ChatMessageMapper;
import com.yqz.webapp.mapper.PetMapper;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetMapper petMapper;
	
	

	@Override
	public List<Pet> getPetList(int pageIndex, int pageSize) {
		return petMapper.getPetList(pageIndex, pageSize);
	}

	@Override
	public Pet getPetById(Integer petId) {
		return petMapper.selectByPrimaryKey(petId);
	}

	

}
