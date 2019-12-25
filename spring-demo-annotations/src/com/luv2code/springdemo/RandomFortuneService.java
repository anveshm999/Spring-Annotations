package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create array of strings
	
	private String[] data = {
			"String 1",
			"String 2",
			"String 3"
	};
	
	//create random number generator
	
	private Random myRandom = new Random();
		
	@Override
	public String getDailyFortune() {
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
