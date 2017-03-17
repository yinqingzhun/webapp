package com.yqz.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqz.webapp.dto.Pet;
import com.yqz.webapp.service.PetService;

@RestController
@RequestMapping(value = "/pet")
public class PetController {
	@Autowired
	PetService petService;

	@RequestMapping(value = "/list")
	public List<Pet> getPetList(@RequestParam(required = false, defaultValue = "1") int pageIndex,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		List<Pet> list = petService.getPetList(pageIndex, pageSize);
		return list;
	}

	@RequestMapping(value = "/{id}")
	public Pet getGet(@PathVariable int id) {
		return petService.getPetById(id);
	}
}
