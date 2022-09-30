package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.exception.UserNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User save(User newUser) {
		return repository.save(newUser);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public String deleteById(Long id) {
		repository.deleteById(id);
		 return  "User with id "+id+" has been deleted success.";
		
	}
	

	
	
}
