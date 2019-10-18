package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import exceptions.IdAlreadyExistException;
import model.Competitor;

class CompetitorTest {

	private Competitor c1;
	private Competitor c2;
	
	public void setupStage() {
		Date d1 = new Date();
		c1 = new Competitor("josue", "rodriguez", "1005969243", "rojopi@", "M", "colombia", "", d1);
		c2 = new Competitor("josue", "rodriguez", "2005625", "rojopi@", "M", "colombia", "", d1); 
	}
	@Test
	void Addtest() throws IdAlreadyExistException {
		setupStage();
		c1.addCompetitor(c2);
		assertTrue(c1.searchCompetitor("2005625")== c2);
	}
	@Test
	void searchTest() {
		setupStage();
		assertTrue(c1.searchCompetitor("1005969243")== c1);
	}


}
