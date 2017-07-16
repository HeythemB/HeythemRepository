package com.heythem.robotEmballage.common;

import java.util.ArrayList;
import java.util.List;

import com.heythem.robotEmballage.models.Article;
import com.heythem.robotEmballage.models.Carton;

public class EmballageUtils {
	
    public static final String SEPARATEUR = "/";
    
	public static List<Article> initChaineArticlesEntree(String chaineEntree){
		List<Article> liste = new ArrayList<Article>();
        if(chaineEntree != null) {
            for(int i=0; i<chaineEntree.length(); i++){
            	liste.add(new Article(Integer.parseInt(chaineEntree.charAt(i) + "")));
            }
        }
		return liste;
	}
	
	public static void logDetailsEmballage(List<Carton> listeCartons){
		final StringBuilder sb = new StringBuilder();
		for(Carton carton : listeCartons){
			for(Article article : carton.getArticles()){
				sb.append(article.getTaille());
			}
			sb.append(SEPARATEUR);
		}
		System.out.print(sb);
	}
}