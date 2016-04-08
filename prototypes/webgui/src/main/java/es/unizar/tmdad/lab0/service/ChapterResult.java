package es.unizar.tmdad.lab0.service;

import java.util.ArrayList;
import java.util.List;

public class ChapterResult {
	private String title;
	private List<ThemeResult> themes;
	
	public ChapterResult(String title){
		this.title = title;
		this.themes = new ArrayList<ThemeResult>();
	}
	
	public ChapterResult(String title, List<ThemeResult> themes) {
		this.title = title;
		this.themes = themes;
		ThemeResult.calculatePercentage(themes);
	}
	
	public void addToken(String themeName, String tokenName, long count){
		ThemeResult theme = themes.stream().filter(t -> t.getName().equals(themeName))
									  		.findFirst().orElse(null);
		if(theme == null){
			theme = new ThemeResult(themeName);
			themes.add(theme);
		}
		theme.addToken(tokenName, count);
		ThemeResult.calculatePercentage(themes);
	}

	public String getTitle() {
		return title;
	}

	public List<ThemeResult> getThemes() {
		return themes;
	}
	
}
