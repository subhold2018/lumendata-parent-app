package com.ld.app.score;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lumendata.attribute.ScoreApp;
import com.lumendata.attribute.score.model.AddressModel;
import com.lumendata.attribute.score.service.AddressScoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScoreApp.class)
public class AddressScoreServiceTest {

	@Autowired
	AddressScoreService addressScoreService;

	private AddressModel address1 = new AddressModel();

	private AddressModel address2 = new AddressModel();

	@Before
	public void testInit(){

		address1.setAddressLine1("19th D cross");
		address1.setAddressLine2("7th Main, BTM 2nd Stage");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setZip(560076);

		address2.setAddressLine1("19th D cross");
		address2.setAddressLine2("7th Main, BTM 2nd Stage");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		address2.setZip(560076);
	}
	
	@Test
	public void testAddressScore(){
		
		//		Address no data
		int score = addressScoreService.getAddressScore(new AddressModel(), address2);
		assertEquals(0, score);

		//		Address exact
		score = addressScoreService.getAddressScore(address1, address2);
		assertEquals(100, score);

		//		Address All words match
		address2.setZip(12345);
		score = addressScoreService.getAddressScore(address1, address2);
		assertEquals(35, score);

		//		Zip 4 digit match
		address2.setZip(560089);
		address2.setAddressLine1("abc");
		score = addressScoreService.getAddressScore(address1, address2);
		assertEquals(4, score);
		
		//		Exact City Match
		score = addressScoreService.getAddressScore(new AddressModel(null, null, "Bareilly", null, 123456),
				new AddressModel(null, null, "Bareilly", null, 123321));
		assertEquals(3, score);
		
		//		Conflict Match
		score = addressScoreService.getAddressScore(new AddressModel("A", "B", "C", "D", 123456),
				new AddressModel("E", "F", "G", "H", 123321));
		assertEquals(0, score);
		
	}

}
