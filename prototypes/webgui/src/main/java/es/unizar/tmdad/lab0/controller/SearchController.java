package es.unizar.tmdad.lab0.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.unizar.tmdad.lab0.service.BookResult;


@RestController
public class SearchController {

    @RequestMapping("/search")
    public BookResult search(@RequestParam("book") String bookName) {
    	// Create dummy results
		BookResult book = new BookResult(bookName);
		
		String chapterName = null;
		
		String ActionTheme = "Accion";
		String HumorTheme = "Humor";
		String LoveTheme = "Amor";
		
		// Prologue
		chapterName = "Prologue";
		book.addToken(ActionTheme, chapterName, "lanza", 3);
		book.addToken(ActionTheme, chapterName, "cuchillo", 3);

		book.addToken(HumorTheme, chapterName, "risa", 3);

		book.addToken(LoveTheme, chapterName, "amor", 1);
		
		// Chapter1
		chapterName = "Chapter 1";
		book.addToken(ActionTheme, chapterName, "lanza", 2);
		book.addToken(ActionTheme, chapterName, "matar", 1);

		book.addToken(HumorTheme, chapterName, "risa", 1);
		book.addToken(HumorTheme, chapterName, "bromea", 2);
		
		// Chapter2
		chapterName = "Chapter 2";
		book.addToken(ActionTheme, chapterName, "matar", 5);
		book.addToken(ActionTheme, chapterName, "cuchillo", 2);
		
		book.addToken(HumorTheme, chapterName, "risa", 4);
		
		book.addToken(LoveTheme, chapterName, "amor", 2);
		book.addToken(LoveTheme, chapterName, "beso", 3);		
		
		// Epilogue
		chapterName = "Epilogue";
		book.addToken(ActionTheme, chapterName, "matar", 1);
		book.addToken(ActionTheme, chapterName, "cuchillo", 2);
		
		book.addToken(HumorTheme, chapterName, "risa", 2);
		book.addToken(HumorTheme, chapterName, "bromea", 4);

		book.addToken(LoveTheme, chapterName, "amor", 3);
		book.addToken(LoveTheme, chapterName, "beso", 4);
    	
		return book;
    }
}