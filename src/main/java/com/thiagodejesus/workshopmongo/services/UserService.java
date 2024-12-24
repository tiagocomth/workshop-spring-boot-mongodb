package com.thiagodejesus.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagodejesus.workshopmongo.domain.User;
import com.thiagodejesus.workshopmongo.dto.UserDTO;
import com.thiagodejesus.workshopmongo.repository.UserRepository;
import com.thiagodejesus.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDto(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}
