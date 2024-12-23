package com.thiagodejesus.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagodejesus.workshopmongo.domain.Post;
import com.thiagodejesus.workshopmongo.domain.User;
import com.thiagodejesus.workshopmongo.repository.PostRepository;
import com.thiagodejesus.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
