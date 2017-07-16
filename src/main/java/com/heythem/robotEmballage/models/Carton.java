package com.heythem.robotEmballage.models;

import java.util.ArrayList;
import java.util.List;

public class Carton {
	private int capacite;
	private List<Article> articles;
	
	public Carton() {
		this.capacite = 0;
		this.articles = new ArrayList<Article>();
	}
	
    public void ajouterArticle(Article article) {
    	this.articles.add(article);
    	setCapacite(getCapacite() + article.getTaille());
    }

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int cartonCapacite) {
		this.capacite = cartonCapacite;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
