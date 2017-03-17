package com.yqz.webapp.service;

import java.util.List;

import com.yqz.webapp.dto.ChatMessageDetailVO;
import com.yqz.webapp.dto.Pet;

public interface PetService {
	List<Pet> getPetList(int pageIndex, int pageSize);

	Pet getPetById(Integer petId);
	
}
