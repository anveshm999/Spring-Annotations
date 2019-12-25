package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired // Field level injections
	@Qualifier("randomFortuneService") // give default bean of implementing class which u need (for multiple implementations scenario)... replace with other fortuneService implementation like randomFortuneService and observe the difference
	private FortuneService fortuneService;
	
	//default constructor
	public TennisCoach() {
		System.out.println("Inside default constructor - TennisCoach");
	}
	
	//define init method
	@PostConstruct
	public void startupStuff(){
		System.out.println("Inside postconstruct annotation method");
	}
	
	//define destroy method
	@PreDestroy
	public void endStuff(){
		System.out.println("Inside predestroy annotation method");
	}
	
	
	/*
	//define setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside setter method - TennisCoach");
		this.fortuneService = fortuneService;
	}*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	


	@Override
	public String getDailyWorkout() {
		return "Practice back-hand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getDailyFortune();
	}

}
