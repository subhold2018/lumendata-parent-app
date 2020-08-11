package com.ld.app.score;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Nysiis;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lumendata.attribute.ScoreApp;
import com.lumendata.attribute.score.service.NameScoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScoreApp.class)
public class NameScoreServiceTest {

	@Autowired
	private NameScoreService nameScoreService;

	@Test
	public void testNameScore(){

		int score = nameScoreService.getNameScore(null, "Bill Clinton");
		assertEquals(0, score);

		score = nameScoreService.getNameScore("Bill Clinton", "Bill Clinton");
		assertEquals(100, score);

		score = nameScoreService.getNameScore("Bill Clinton", "Bil. Clinton");
		assertEquals(95, score);

		score = nameScoreService.getNameScore("Bill Clinton", "Bil Clinton");
		assertEquals(85, score);

		score = nameScoreService.getNameScore("Bill J Clinton", "Bill Clinton");
		assertEquals(60, score);

		score = nameScoreService.getNameScore("Bil. Cllinton", "William Clinton");
		assertEquals(50, score);

		score = nameScoreService.getNameScore("Bill Clinton", "Bill Cllinton");
		assertEquals(25, score);

		score = nameScoreService.getNameScore("Billy Clinton", "Bil Clintonn");
		assertEquals(18, score);

		score = nameScoreService.getNameScore("Billy Clinton", "Big J Cameron");
		assertEquals(16, score);

		score = nameScoreService.getNameScore("Harpreet Singh", "Harpreet Singh Saluja");
		assertEquals(12, score);

		score = nameScoreService.getNameScore("Harpreet Singh", "Harpreet Sinh Saluja");
		assertEquals(10, score);

		score = nameScoreService.getNameScore("Bill Abraham", "William Abbrahamm");
		assertEquals(8, score);

		score = nameScoreService.getNameScore("Fanny Kelly", "FRANCES Blahay");
		assertEquals(3, score);

		score = nameScoreService.getNameScore("William Kelly", "John Kelly");
		assertEquals(-70, score);

		score = nameScoreService.getNameScore("William Kelly", "Fanny Kelly");
		assertEquals(-75, score);


	}

	@Test
	public void testSoundex() throws Exception {
		Soundex soundex=new Soundex();
		System.out.print(soundex.encode("john")+" : ");
		System.out.println(soundex.encode("jim"));
		assertEquals(soundex.encode("john"),soundex.encode("jim"));

		System.out.print(soundex.encode("john")+" : ");
		System.out.println(soundex.encode("june"));
		assertEquals(soundex.encode("john"),soundex.encode("june"));

		System.out.print(soundex.encode("john")+" : ");
		System.out.println(soundex.encode("jane"));
		assertEquals(soundex.encode("john"),soundex.encode("jane"));

		System.out.print(soundex.encode("john")+" : ");
		System.out.println(soundex.encode("johannes"));
		assertNotSame(soundex.encode("john"),soundex.encode("johannes"));

		System.out.print(soundex.encode("john")+" : ");
		System.out.println(soundex.encode("johan"));
		assertEquals(soundex.encode("john"),soundex.encode("johan")); 

		System.out.print(soundex.encode("johan")+" : ");
		System.out.println(soundex.encode("johannes"));
		assertNotSame(soundex.encode("johan"),soundex.encode("johannes"));
	}


	@Test
	public void testMetaphone() throws Exception {

		Soundex soundex = new Soundex();
		// Timothy = T530 Tim = T500, Timmy = T500
		System.out.print("Timothy = "+soundex.encode("Timothy")+", ");
		System.out.print("Tim = "+soundex.encode("Tim")+", ");
		System.out.println("Timmy = "+soundex.encode("Timmy"));

		Nysiis nysiis = new Nysiis();
		// Timothy = TANATY, Tim =TAN, Timmy = TANY
		System.out.print("Timothy = "+nysiis.encode("Timothy")+", ");
		System.out.print("Tim = "+nysiis.encode("Tim")+", ");
		System.out.println("Timmy = "+nysiis.encode("Timmy"));

		DoubleMetaphone doubleMetaphone = new DoubleMetaphone();
		// Timothy = TM0, Tim = TM, Timmy = TM

		System.out.print("Timothy = "+doubleMetaphone.encode("Timothy")+", ");
		System.out.print("Tim = "+doubleMetaphone.encode("Tim")+", ");
		System.out.println("Timmy = "+doubleMetaphone.encode("Timmy"));
	}

}
