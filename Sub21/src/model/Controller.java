package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.View;

import exceptions.IdAlreadyExistException;

public class Controller {
	private Competitor first;
	private Viewer root;

	public Controller() {
		this.first = null;
		this.root = null;
	}

	public Competitor getFirst() {
		return first;
	}

	public void setFirst(Competitor first) {
		this.first = first;
	}

	public Viewer getRoot() {
		return root;
	}

	public void setRoot(Viewer root) {
		this.root = root;
	}

	public void read(String in) {

		File file = new File(in);
		if (file.exists()) {
			if (file.isFile()) {
				try {
					BufferedReader be = new BufferedReader(new FileReader(file));
					String bu = "";
					String aux = "";
					boolean ce = false;
					boolean sa = false;
					while ((aux = be.readLine()) != null) {
						bu = aux;
						String a = bu.toString();
						String[] parts = a.split(",");

						if (sa == false) {
							sa = true;
						} else {
							if (!ce) {
								addViewer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],
										parts[7]);
								ce = true;
							} else {
								addCompetitor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6],
										parts[7]);
								ce = false;
							}
						}

					}
				} catch (Exception e) {
					
				}
			}
		}

	}

	public Viewer searchViewer(String id) {
		Viewer tem = null;
		if (root == null) {

		} else {
			tem = root.searchViewer(id);
		}
		return tem;
	}

	public Competitor searchCompetitor(String id) {
		Competitor tem = null;
		if (first != null) {
			tem = first.searchCompetitor(id);
		}
		return tem;
	}

	public void addViewer(String name, String lastName, String id, String email, String gender, String contry,
			String photo, String birthday) throws IdAlreadyExistException {

		Viewer v = new Viewer(name, lastName, id, email, gender, contry, photo, birthday);
		if (root == null) {
			root = v;
		} else {
			root.addViewer(v);
		}

	}

	public void addCompetitor(String name, String lastName, String id, String email, String gender, String contry,
			String photo, String birthday) throws IdAlreadyExistException {

		Competitor v = new Competitor(name, lastName, id, email, gender, contry, photo, birthday);
		if (first == null) {
			first = v;
		} else {
			first.addCompetitor(v);
		}

	}
	
	public String searchCountry(String country) throws IdAlreadyExistException {
		String ms = "";
		Viewer tem = searchCountryPro(country);
		if(tem != null) {
			ms += tem.paintTree();
		}else {
			ms += "there are no people from that country";
		}
		
		return ms;
	}
	
	public Viewer searchCountryPro(String country) throws IdAlreadyExistException {
		Viewer tem = null;
		if(root!=null) {
			if(root.searchCountry(country)!= null) {
				tem = root.searchCountry(country);
			}
		}
		if(first!= null) {
			if(first.searchCountry(country)!=null) {
				Competitor tem1 = first.searchCountry(country);
				while (tem1!=null) {
					Viewer w = new Viewer(tem1.getName(), tem1.getLastName(), tem1.getId(), tem1.getEmail(), tem1.getGender(), tem1.getContry(), tem1.getPhoto(), tem1.getBirthday());
					
					if(tem == null) {
						tem = w;
					}else {
						tem.addViewer(w);
					}
					tem1 = tem1.getNext();
				}
			}
		}
		return tem;
	}
}
