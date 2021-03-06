package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.models.entity.UserProfile;

@RestController
public class UserProfileController {
	

	@GetMapping("/user/{id}")
	public UserProfile get(@PathVariable("id") String id) {
		return mapper.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile>getList(){
		return mapper.getList();
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address")String address){
		mapper.insertUserProfile(id, name, phone, address);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address")String address) {
		mapper.updateUserProfile(id, name, phone, address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
	}
	
	//CONSTRUCTOR -----------
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	//-----------------------
	
	
	
	private UserProfileMapper mapper;
	
}
