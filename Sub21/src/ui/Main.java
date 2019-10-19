package ui;

import model.*;

import java.io.IOException;
import java.util.*;


public class Main {
	private Controller co;
	private Scanner reader;

	public Main() {
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) throws Exception {
		Main execute = new Main();
		execute.menu();
	}

	public void menu() throws Exception {
		int userInput = 0;

		co = new Controller();
		System.out.println("");
		System.out.println("");

		// WELCOME
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Welcome to the best lab in the world");
		System.out.println("enjoy your stay :3");
		System.out.println("-----------------------------------------------------------------");
		while (userInput != 5) {

			showControllerOp();

			System.out.println("------------------------------------------");
			System.out.print("| Type the number of your selection: ");
			try {
				userInput = reader.nextInt();
				reader.nextLine();
				System.out.println("--------------------------------------");

				switch (userInput) {

				case 1:
					loadData();
					break;

				case 2:
					searchViewer();
					break;

				case 3:
					searchCompetitor();
					break;

				case 4:
					
					
					break;
				case 5:
					
					break;

				default:
					System.out.println();
					System.out.println("Please type a number between 1 and 5");
					System.out.println();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.print("ERROR: Invalid option");
				reader.nextLine();
				System.out.println();
			}

		}

	}

	public void showControllerOp() {

		System.out.println("--------------------------------------- \n");
		System.out.println("1. Load Data.");
		System.out.println("2. Search viewer by id.");
		System.out.println("3. Search participants by id.");
		System.out.println("4. Visualize the data of the two \n   structures of a given country.");
		System.out.println("5. CHAU ");
		System.out.println("----------------------------------------- \n");
	}
	
	public void loadData() {
		System.out.println("please enter the relative path \n");
		String ms = reader.nextLine();
		co.read(ms);
		if(co.getFirst() != null) {
			System.out.println("the data was loaded correctly");
		}else {
			System.out.println("the data was not loaded");
		}
	}
	
	public void searchViewer() {
		System.out.println("please enter the id of the viewer \n");
		String ms = reader.nextLine();
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		String viewer = co.searchViewer(ms).toString();
		TFin = System.currentTimeMillis();
		tiempo = TFin-TInicio;
		System.out.println("the viewer's information is " + viewer + "and it took time to find: " + tiempo);;
	}
	
	public void searchCompetitor() {
		System.out.println("please enter the id of the competitor \n");
		String ms = reader.nextLine();
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		String competitor = co.searchCompetitor(ms).toString();
		TFin = System.currentTimeMillis();
		tiempo = TFin-TInicio;
		System.out.println("the viewer's information is " + competitor + "and it took time to find: " + tiempo);;
	}
	
	public void searchCountry() {
		System.out.println("please enter the country you want to search");
		String ms = reader.nextLine();
		try {
		System.out.println(co.searchCountry(ms));
		}catch (Exception e) {
			System.out.println("the loaded data had some fault");
		}
	}

}