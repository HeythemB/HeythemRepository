package com.heythem;

import java.util.List;

import com.heythem.robotEmballage.common.EmballageUtils;
import com.heythem.robotEmballage.models.Article;
import com.heythem.robotEmballage.models.Carton;
import com.heythem.robotEmballage.services.ServiceEmballage;
import com.heythem.robotEmballage.services.ServiceEmballage_v1;
import com.heythem.robotEmballage.services.ServiceEmballage_v2;

public class Main {
	public static void main(final String[] args) {
        String articlesEnEntree = "163841689525773";
        System.out.println("Articles : " + articlesEnEntree);
        
        //Préparation des articles
        List<Article> articlesPrepares = EmballageUtils.initChaineArticlesEntree(articlesEnEntree);
        
        //Emballage des articles : Algorithme basique
        ServiceEmballage service_v1 = new ServiceEmballage_v1();
        List<Carton> articlesEmballes = service_v1.traiterArticles(articlesPrepares);
        
        //Details de l'emballage effectué
        System.out.print("Robot actuel : ");
        EmballageUtils.logDetailsEmballage(articlesEmballes);
        System.out.println(" => " + articlesEmballes.size() + " cartons utilisés");
        
        //Emballage des articles : Algorithme optimisé
        ServiceEmballage service_v2 = new ServiceEmballage_v2();
        List<Carton> articlesEmballes2 = service_v2.traiterArticles(articlesPrepares);
        
        //Details de l'emballage effectué
        System.out.print("Robot optimisé : ");
        EmballageUtils.logDetailsEmballage(articlesEmballes2);
        System.out.println(" => " + articlesEmballes2.size() + " cartons utilisés");
	}
}