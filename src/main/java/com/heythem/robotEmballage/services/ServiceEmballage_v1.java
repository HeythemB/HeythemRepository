package com.heythem.robotEmballage.services;

import java.util.ArrayList;
import java.util.List;

import com.heythem.robotEmballage.models.Article;
import com.heythem.robotEmballage.models.Carton;

public class ServiceEmballage_v1 implements ServiceEmballage {
	
    public static final int CAPACITE_CARTON = 10;
    
	public List<Carton> traiterArticles(List<Article> articles) {
		
		List<Carton> cartons = new ArrayList<Carton>();
		Carton carton = new Carton();
		if(articles != null && !articles.isEmpty()){
			carton.ajouterArticle(articles.get(0));
			int capacite = 0;
			for(int i = 1; i < articles.size(); i++){
				Article articleEnTraitement = articles.get(i);
				capacite += articleEnTraitement.getTaille();
				if(capacite < CAPACITE_CARTON){
					carton.ajouterArticle(articleEnTraitement);
				}else if(capacite > CAPACITE_CARTON){
					cartons.add(carton);
					carton = new Carton();
					carton.ajouterArticle(articleEnTraitement);
				}else{
					carton.ajouterArticle(articleEnTraitement);
					cartons.add(carton);
					carton = new Carton();
				}
				capacite = carton.getCapacite();
			}
		}
		
		return cartons;
	}
}