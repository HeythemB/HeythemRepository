package com.heythem.robotEmballage.models;

public class Article {
	private int taille;
	
	public Article(int articleTaille) {
		this.taille = articleTaille;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int articleTaille) {
		this.taille = articleTaille;
	}
}
