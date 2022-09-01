package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.model.Post;
import com.post.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postservice;
	
	@GetMapping("/post")
	public List<Post> getAllPost() {
		return postservice.getAllPosts();
	}
	@GetMapping("/post/{id}")
	public Post getOnePost(@PathVariable("id") int id) {
		return postservice.getOnePost(id);
	}
	@PostMapping("/post")
	public ResponseEntity<Post> addPost(@RequestBody Post p){
		return postservice.addPost(p);
	}
	@PutMapping("/post/{id}")
	public ResponseEntity<Post> updatePost(@RequestBody Post p,@PathVariable("id") int id) {
		return postservice.putPost(p, id);
	}
	@DeleteMapping("/post/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable("id") int id) {
		return postservice.deletePost(id);
	}
	
}
