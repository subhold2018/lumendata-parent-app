package com.ld.app.score;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lumendata.attribute.ScoreApp;
import com.lumendata.attribute.score.service.EmailScoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScoreApp.class)
public class EmailScoreServiceTest {
	
	@Autowired
	private EmailScoreService emailScoreService;

	@Test
	public void testEmailScore(){

		int score = emailScoreService.getEmailScore(null, "jeet@gmail.com");
		assertEquals(0, score);

		score = emailScoreService.getEmailScore("jeet@gmail.com", "jeet@gmail.com");
		assertEquals(100, score);

		score = emailScoreService.getEmailScore("jeet@gmail.com", "jeet@yahoo.com");
		assertEquals(75, score);
		
		score = emailScoreService.getEmailScore("jeet@gmail.com", "jeet1@gmail.com");
		assertEquals(40, score);

		score = emailScoreService.getEmailScore("jeet@gmail.com", "gangwar11@gmail.com");
		assertEquals(0, score);
		
		score = emailScoreService.getEmailScore("", "");
		assertEquals(0, score);
	
	}
}
