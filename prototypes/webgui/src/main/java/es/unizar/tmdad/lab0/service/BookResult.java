package es.unizar.tmdad.lab0.service;

import java.util.ArrayList;
import java.util.List;

public class BookResult {
	private String book;
	private List<ChapterResult> chapters;
	private List<ThemeResult> themes;
	
	public BookResult(String book){
		this.book = book;
		this.chapters = new ArrayList<ChapterResult>();
		this.themes = new ArrayList<ThemeResult>();
	}
	
	public void addToken(String themeName, String chapterName, String tokenName, long count){
		ChapterResult chapter = chapters.stream().filter(c -> c.getTitle().equals(chapterName))
									  		.findFirst().orElse(null);
		if(chapter == null){
			chapter = new ChapterResult(chapterName);
			chapters.add(chapter);
		}
		
		chapter.addToken(themeName,  tokenName, count);
		
		ThemeResult theme = themes.stream()
								  .filter(t -> t.getName().equals(themeName))
								  .findFirst().orElse(null);
		if(theme == null){
			theme = new ThemeResult(themeName);
			themes.add(theme);
		}
		theme.addToken(tokenName, count);
		ThemeResult.calculatePercentage(themes);
	}

	public String getBook() {
		return book;
	}
	
	public List<ThemeResult> getThemes() {
		return themes;
	}
	
	public List<ChapterResult> getChapters(){
		return chapters;
	}

	
}
