package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import exceptions.IdAlreadyExistException;
import model.Controller;
import model.Viewer;


class ControllerTest {
	private Controller c1;
	public void setupStage() throws IdAlreadyExistException {
		c1 = new Controller(); 
		c1.addViewer("josue", "rodriguez", "1005969243", "rojopi@", "M", "colombia", "", "02/1/2000");
		c1.addViewer("josue", "rodriguez", "2005625", "rojopi@", "M", "colombia", "", "02/1/2000");
	}
	public void setupStage1() throws IdAlreadyExistException {
		c1 = new Controller(); 
		c1.addCompetitor("josue", "rodriguez", "1005969243", "rojopi@", "M", "colombia", "", "02/1/2000");
		c1.addCompetitor("josue", "rodriguez", "2005625", "rojopi@", "M", "colombia", "", "02/1/2000");
	}
	public void setupStage2() {
		c1 = new Controller();
	}
	@Test
	void addViwerTest() throws IdAlreadyExistException {
		setupStage();
		assertTrue(c1.getRoot() !=null);
	}
	
	@Test
	void addCompetitorTest() throws IdAlreadyExistException {
		setupStage1();
		assertTrue(c1.getFirst() !=null);
	}
	
	@Test
	void searchCompetitorTest() throws IdAlreadyExistException {
		setupStage1();
		assertTrue(c1.searchCompetitor("2005625") !=null);
	}
	@Test
	void loadTest() {
		setupStage2();
		c1.read("./reader/MOCK_DATA (1).csv");
		
		assertTrue(c1.getRoot() != null);
	}
	@Test
	void painTest() throws IdAlreadyExistException {
		setupStage2();
		c1.read("./reader/MOCK_DATA (1).csv");
		assertTrue((c1.searchCountry("colombia").equals("there are no people from that country")));
	}
}
