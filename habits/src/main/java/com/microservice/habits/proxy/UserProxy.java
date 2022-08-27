package com.microservice.habits.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service",url="localhost:8765")
public interface UserProxy {
	@GetMapping("/user-service/user/get/{id}")
	public Integer retrieveUserId(@PathVariable Integer id);
	
}
