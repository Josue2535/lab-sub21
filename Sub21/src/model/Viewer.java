package model;

import java.util.Date;

import javax.swing.text.View;

import exceptions.IdAlreadyExistException;

public class Viewer extends Person{
	private Viewer right;
	private Viewer left;
	public Viewer(String name, String lastName, String id, String email, String gender, String contry, String photo,
			Date birthday) {
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
		if(right == null && left == null) {
			is = true;
		}
		return is;
	}
	public void addViewer(Viewer ne) throws IdAlreadyExistException {
		if(compareTo(ne)>0) {
			if(left == null) {
				left = ne;
			}else {
				left.addViewer(ne);
			}
		}
		if(compareTo(ne)<0) {
			if(right == null) {
				right = ne;
			}else {
				right.addViewer(ne);
			}
		}else {
			throw new IdAlreadyExistException("it`s already exist");
		}
	}
	
	public Viewer searchViewer(String id) {
		if( getId().compareToIgnoreCase( id ) == 0 )
            return this;
        else if( getId().compareToIgnoreCase( id ) > 0 )
            return ( left == null ) ? null : left.searchViewer(id);
        else
            return ( right == null ) ? null : right.searchViewer(id);
	}
	
	
	
	
}
