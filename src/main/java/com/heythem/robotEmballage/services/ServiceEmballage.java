package com.heythem.robotEmballage.services;

import java.util.List;

import com.heythem.robotEmballage.models.Article;
import com.heythem.robotEmballage.models.Carton;

public interface ServiceEmballage {
	List<Carton> traiterArticles(final List<Article> articles);
}