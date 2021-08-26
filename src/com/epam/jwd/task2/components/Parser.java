package com.epam.jwd.task2.components;

import com.epam.jwd.task2.printer.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    private ArrayList<Sentence> sentences;
	private final static String SYMBOLS = "\u2026.!?;}";
	private static final Logger logger = LogManager.getLogger(Parser.class);

	public void parse(BufferedReader reader) throws IOException {

		logger.debug("Conversion String to Sentences started");
		String sentence = " ";
		String[] sentences;
		this.sentences = new ArrayList<>();
		StringBuilder line = new StringBuilder(reader.readLine());
		String readLine = line.toString();
		while (readLine != null) {

			if (readLine.equals("")) {
				readLine = reader.readLine();
				line.append(readLine);
				continue;
			}

			int i;
			int index = 0;
			String specialSymbol = "";

			if (SYMBOLS.indexOf(line.charAt(line.length() - 1)) > -1) {
				specialSymbol += line.charAt(line.length() - 1);
			}

			sentences = line.toString().split("[.;!?}\u2026]+");
			for (i = 0; i < sentences.length - 1; i++) {
				sentence = sentences[i] + line.charAt(sentences[i].length() + index);
				index += sentence.length();
				this.sentences.add(new Sentence(sentence));
			}
			sentence = sentences[i] + specialSymbol;
			if (!specialSymbol.equals("")) {
				this.sentences.add(new Sentence(sentence));
				sentence = "";
			}
			readLine = reader.readLine();
			line = new StringBuilder(sentence + " " + readLine);
		}
	}

	public ArrayList<Sentence> getSentences() {
		return sentences;
	}

	@Override
	public String toString() {
		return  sentences.toString();

	}
}
