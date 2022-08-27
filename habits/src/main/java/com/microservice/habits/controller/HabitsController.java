package com.microservice.habits.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.habits.entities.Habit;
import com.microservice.habits.proxy.UserProxy;
import com.microservice.habits.repository.HabitRepository;

@RestController
public class HabitsController {

	@Autowired
	private HabitRepository habitRepository;
	
	@Autowired
	private UserProxy userProxy;
	
	
	/*
	@GetMapping("/{user}/habits")
	public Habit getHabits(@PathVariable Integer user) {
		Optional<Habit> habit = habitRepository.findById(user);
		
		if(habit.isPresent()) {
			return habit.get();
		}else {
			return null;
		}
		//return habitRepository.findByUserid(user);
	}
	*/
	
	
	@GetMapping("/user/{user}/habits")
	public List<Habit> getHabits(@PathVariable Integer user) {
		Integer id = userProxy.retrieveUserId(user);
		System.out.println(id);
		if(id != null) {
			return habitRepository.findByUserId(user);
		}
		return null;
		
		
		//return habitRepository.findByUserid(user);
	}
	@PostMapping("/user/{user}/habits")
	public ResponseEntity<Object> createHabit(@RequestBody Habit habit, @PathVariable Integer user) {
		Integer id = userProxy.retrieveUserId(user);
		System.out.println(id);
		if(id != null) {
			habitRepository.save(habit);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@PutMapping("/user/{user}/habits/{habit}")
	public ResponseEntity<Object> updateHabit(@PathVariable Integer habit, @PathVariable Integer user,@RequestBody Habit updatedHabit) {
		
		Optional<Habit> habitOptional = habitRepository.findById(habit);
		
		if(habitOptional.isPresent()) {
			habitRepository.save(updatedHabit);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
