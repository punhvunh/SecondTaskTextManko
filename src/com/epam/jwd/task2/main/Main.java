package com.epam.jwd.task2.main;

import com.epam.jwd.task2.components.Parser;
import com.epam.jwd.task2.logic.Logic;
import com.epam.jwd.task2.printer.Printer;
import com.epam.jwd.task2.reader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Objects;


public class Main {
	public static final int NUMBER_OF_LETTERS = 4;
	public static final int LENGTH_OF_WORD = 6;
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) throws IOException {

		Parser parser = new Parser();
		logger.info("Parser starts");
		parser.parse(Reader.reader());
		Printer.printStringLn("Number Of Sentences With Equal Words: " + Logic.countEqualWordsInSentences(parser.getSentences()));
		Printer.printStringLn("Sentences By Increasing Numbers Of Words:\n " + Logic.getSentencesByIncreasingNumbersOfWords(parser.getSentences()));
		Printer.printStringLn("Find Words In exclamatory Sentences By Length: " + Logic.findWordsInExclamatorySentencesByLength(parser.getSentences(),NUMBER_OF_LETTERS));
		Printer.printStringLn("Find word not in sentences: " + Objects.requireNonNull(Logic.findWordNotInSentences(parser.getSentences())).getText());
		Printer.printStringLn("Switch first and last word in sentence:");
		Logic.switchFirstAndLastWordInSentence(parser.getSentences());
		Printer.printStringLn("Get string in random sentence: ");
		Logic.getStringInRandomSentence(parser.getSentences(),LENGTH_OF_WORD);
	}

}
