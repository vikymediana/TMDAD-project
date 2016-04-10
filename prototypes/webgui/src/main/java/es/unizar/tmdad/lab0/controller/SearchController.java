package es.unizar.tmdad.lab0.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unizar.tmdad.lab0.service.BookResult;


@RestController
public class SearchController {

	@RequestMapping(value="/themes", method={RequestMethod.GET}, params={"like"})
	public List<Map<String, String>> themeslike(@RequestParam("like") String like){
		// TODO: Move like query to dummy db
		List<String> themes = new ArrayList<String>();
		themes.add("Accion");
		themes.add("Humor");
		themes.add("Amor");


		return themes.stream()
				.filter(t -> t.toLowerCase().contains(like.toLowerCase()))
				.map(t -> Collections.singletonMap("value",  t))
				.collect(Collectors.toList());
	}

	@RequestMapping("/search")
	public BookResult search(@RequestParam("book") String bookName, @RequestParam("themes[]") List<String> themes) {
		// Create dummy results
		BookResult book = new BookResult(bookName);

		String chapterName = null;

		String ActionTheme = "Accion";
		String HumorTheme = "Humor";
		String LoveTheme = "Amor";

		// Prologue
		chapterName = "Prologue";
		
		if(themes.contains(ActionTheme)){
			book.addToken(ActionTheme, chapterName, "lanza", 3);
			book.addToken(ActionTheme, chapterName, "cuchillo", 3);
		}
		if(themes.contains(HumorTheme)){
			book.addToken(HumorTheme, chapterName, "risa", 3);
		}
		if(themes.contains(LoveTheme)){
			book.addToken(LoveTheme, chapterName, "amor", 1);
		}
		// Chapter1
		chapterName = "Chapter 1";

		if(themes.contains(ActionTheme)){
			book.addToken(ActionTheme, chapterName, "lanza", 2);
			book.addToken(ActionTheme, chapterName, "matar", 1);
		}
		if(themes.contains(HumorTheme)){
			book.addToken(HumorTheme, chapterName, "risa", 1);
			book.addToken(HumorTheme, chapterName, "bromea", 2);
		}
		// Chapter2
		chapterName = "Chapter 2";
		
		if(themes.contains(ActionTheme)){
			book.addToken(ActionTheme, chapterName, "matar", 5);
			book.addToken(ActionTheme, chapterName, "cuchillo", 2);
		}
		if(themes.contains(HumorTheme)){
			book.addToken(HumorTheme, chapterName, "risa", 4);
		}
		if(themes.contains(LoveTheme)){
			book.addToken(LoveTheme, chapterName, "amor", 2);
			book.addToken(LoveTheme, chapterName, "beso", 3);		
		}
		// Epilogue
		chapterName = "Epilogue";
		
		if(themes.contains(ActionTheme)){
			book.addToken(ActionTheme, chapterName, "matar", 1);
			book.addToken(ActionTheme, chapterName, "cuchillo", 2);
		}
		if(themes.contains(HumorTheme)){
			book.addToken(HumorTheme, chapterName, "risa", 2);
			book.addToken(HumorTheme, chapterName, "bromea", 4);
		}
		if(themes.contains(LoveTheme)){
			book.addToken(LoveTheme, chapterName, "amor", 3);
			book.addToken(LoveTheme, chapterName, "beso", 4);
		}

		return book;
	}
}