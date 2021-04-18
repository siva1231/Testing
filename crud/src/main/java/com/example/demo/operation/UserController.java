package com.example.demo.operation;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return userRepository.save(user);
		
	}
	@GetMapping("/all")
	
	public List<User> users(){
		System.out.println("getting all users");
		return userRepository.findAll();
		
	}
	
@GetMapping("/{id}")
	
	public User user(@PathVariable(value="id")int id){
		return userRepository.findById(id);
		
	}
@DeleteMapping("/{id}")
   public User delete(@PathVariable(value="id")int id){
	return userRepository.deleteById(id);
	
}
@GetMapping("/query")

public User info(@RequestParam("getid")int id){
	return userRepository.findById(id);
	
}




}
