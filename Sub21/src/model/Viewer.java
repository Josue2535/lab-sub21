package model;

import java.util.Date;

import javax.swing.text.View;

import exceptions.IdAlreadyExistException;

public class Viewer extends Person {
	private Viewer right;
	private Viewer left;

	public Viewer(String name, String lastName, String id, String email, String gender, String contry, String photo,
			String birthday) {
		super(name, lastName, id, email, gender, contry, photo, birthday);
		this.left = null;
		this.right = null;
	}

	public Viewer getRight() {
		return right;
	}

	public void setRight(Viewer right) {
		this.right = right;
	}

	public Viewer getLeft() {
		return left;
	}

	public void setLeft(Viewer left) {
		this.left = left;
	}

	public boolean isSheet() {
		boolean is = false;
		if (right == null && left == null) {
			is = true;
		}
		return is;
	}

	public void addViewer(Viewer ne) throws IdAlreadyExistException {
		if (ne != null) {
			if (compareTo(ne) > 0) {
				if (left == null) {
					left = ne;
				} else {
					left.addViewer(ne);
				}
			}
			if (compareTo(ne) < 0) {
				if (right == null) {
					right = ne;
				} else {
					right.addViewer(ne);
				}
			} else {
				throw new IdAlreadyExistException("it`s already exist");
			}
		} else {

		}
	}

	public Viewer searchViewer(String id) {
		if (getId().compareToIgnoreCase(id) == 0)
			return this;
		else if (getId().compareToIgnoreCase(id) > 0)
			return (left == null) ? null : left.searchViewer(id);
		else
			return (right == null) ? null : right.searchViewer(id);
	}

	public Viewer searchCountry(String country) throws IdAlreadyExistException {
		Viewer tem = null;
		if (getContry().equalsIgnoreCase(country)) {
			tem = this;
		}
		if (left != null) {
			if (tem == null) {
				tem = left.searchCountry(country);
			} else {
				tem.addViewer(left.searchCountry(country));
			}
		}
		if (right != null) {
			if (tem == null) {
				tem = right.searchCountry(country);
			} else {
				tem.addViewer(right.searchCountry(country));
			}
		}
		return tem;
	}

	public String paintTree() {
		String ms = "";
		if (ms.equals("")) {
			ms += this.toString() + "\n";
			ms += "|___";
			if (left != null) {
				ms += "\n" + "|___";
				ms += left.paintTree();
			}
			if (right != null) {
				ms += "\n" + "|___";
				ms += right.paintTree();
			}
			ms += "\n";

		}

		return ms;
	}

}
