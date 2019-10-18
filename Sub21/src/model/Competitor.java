package model;

import java.util.Date;

import exceptions.IdAlreadyExistException;

public class Competitor extends Person {
	private Competitor next;
	private Competitor before;

	public Competitor(String name, String lastName, String id, String email, String gender, String contry, String photo,
			Date birthday) {
		super(name, lastName, id, email, gender, contry, photo, birthday);
		this.before = null;
		this.next = null;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}

	public Competitor getBefore() {
		return before;
	}

	public void setBefore(Competitor before) {
		this.before = before;
	}

	public void addCompetitor(Competitor ne) throws IdAlreadyExistException {
		if (compareTo(ne) == 0) {
			throw new IdAlreadyExistException("it`s already exist");
		}
		if (compareTo(ne) < 0) {
			if (next == null) {
				addNext(ne);
			} else {
				next.addCompetitor(ne);
			}
		}
		if (compareTo(ne) > 0) {
			addBefore(ne);
		}

	}

	public void addBefore(Competitor com) {
		if (before != null) {
			this.before.setNext(com);
			com.setBefore(this.before);
			com.setNext(this);
			before = com;
		} else {
			com.setNext(this);
			before = com;
		}
	}

	public void addNext(Competitor com) {
		if (next != null) {
			next.addBefore(com);
		} else {
			next = com;
			com.setBefore(this);
		}
	}

	public Competitor searchCompetitor(String id) {
		Competitor tem = this;
		boolean ce = false;
		while (tem != null && !ce) {
			if(tem.getId().equalsIgnoreCase(id)) {
				ce = true;
			}else {
				tem = tem.getNext();
			}
			
		}
		return tem;
	}

}
