package pablo.fernandez.dam.mp09.uf03.a01.domain;

import java.io.Serializable;

public class Llibre implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String author;
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}
	

	@Override
	public String toString() {
		return "Libro [titulo=" + title + ", autor=" + author +"]";
	}

}

	
