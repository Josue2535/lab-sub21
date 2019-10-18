package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import exceptions.IdAlreadyExistException;
import model.Viewer;

class ViewerTest {
	private Viewer w1;
	private Viewer w2;
	
	public void setupStage() {
		
		w1 = new Viewer("josue", "rodriguez", "1005969243", "rojopi@", "M", "colombia", "", "");
		w2 = new Viewer("josue", "rodriguez", "2005625", "rojopi@", "M", "colombia", "", ""); 
	}
	@Test
	void Addtest() throws IdAlreadyExistException {
		setupStage();
		w1.addViewer(w2);
		assertTrue(w1.searchViewer("2005625")== w2);
	}
	@Test
	void searchTest() {
		setupStage();
		assertTrue(w1.searchViewer("2005625")== null);
	}

}
