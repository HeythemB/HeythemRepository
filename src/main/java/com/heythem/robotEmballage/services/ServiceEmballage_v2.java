package com.heythem.robotEmballage.services;

import java.util.ArrayList;
import java.util.List;

import com.heythem.robotEmballage.models.Article;
import com.heythem.robotEmballage.models.Carton;

public class ServiceEmballage_v2 implements ServiceEmballage {
	
	public static final int CAPACITE_CARTON = 10;
	
	public List<Carton> traiterArticles(List<Article> articles) {
		
		List<Carton> cartons = new ArrayList<Carton>();
		Carton carton = new Carton();
		if(articles != null && !articles.isEmpty()){
			int capacite = 0;
			do{
	    		if(capacite == 0){
	    			carton.ajouterArticle(articles.get(0));
	    			capacite = carton.getCapacite();
	    			articles.remove(0);
	    		}
	    		
	    		Integer preference_ = CAPACITE_CARTON - capacite;
	    		Article elementSuivant = getElementSuivant(articles, preference_);
	    		if(elementSuivant != null){
	    			carton.ajouterArticle(elementSuivant);
	    			if(carton.getCapacite() == CAPACITE_CARTON){
	    				cartons.add(carton);
	    				carton = new Carton();
	    			}
	    			capacite = carton.getCapacite();
	    			articles.remove(elementSuivant);
	    		}else{
    				cartons.add(carton);
    				carton = new Carton();
    				capacite = 0;
	    		}
	    		
			}while(articles.size() != 0);
		}
		
		return cartons;
	}

	public static Article getElementSuivant(List<Article> articles, Integer preference_) {
	    Article default_ =  null;
	    for(Article article : articles){
	    	if(article.getTaille() == preference_){
	    		return article;
	    	}else if(article.getTaille() < preference_){
	    		default_ = article;
	    	}
	    }
	    return default_;
	}
}
