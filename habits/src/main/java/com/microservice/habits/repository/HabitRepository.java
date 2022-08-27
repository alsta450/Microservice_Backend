package com.microservice.habits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.habits.entities.Habit;

public interface HabitRepository extends JpaRepository<Habit,Integer>{
	public List<Habit> findByUserId(Integer userId);
}
