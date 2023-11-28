package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.MediaType; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pojo.Feedback;
import com.ecommerce.rep.FeedbackRepository; 

@RestController
public class FeedbackController {
	private final FeedbackRepository feedbackRepository; 
	@Autowired 
	public FeedbackController(
			FeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
		} 
	@PostMapping
	(
			value = "/api/feedback", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) 
	public String createFeedback(
			@RequestParam("comment") 
			String comment, @RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("rating") int rating) { Feedback feedback = new Feedback(name, email, rating, comment); 
			feedbackRepository.save(feedback);
			return "Feedback submitted successfully"; 
			}
	}