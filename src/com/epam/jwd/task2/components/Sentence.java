package com.epam.jwd.task2.components;

import com.epam.jwd.task2.printer.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class Sentence implements Comparable {
	private ArrayList<Word> words;
	private String text;
	public final static String SYMBOLS = "\u2026.!?,:)}";
	private static final Logger logger = LogManager.getLogger(Parser.class);

	public Sentence(String sentence) {
		logger.debug("Conversion Sentences to Word started");
		this.text = sentence;
		this.words  = new ArrayList<>();
		String[] words = sentence.split("[ ]");


		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals("")) {
				if (SYMBOLS.indexOf(words[i].charAt(words[i].length() - 1)) > -1) {
					this.words .add(new Word(words[i].substring(0, words[i].length() - 1)));
					this.words .add(new Word("" + words[i].charAt(words[i].length() - 1)));
				} else {
					this.words .add(new Word(words[i]));
				}

			}
		}
		Printer.printStringLn("\n");
	}

	public String getText() {
		return text;
	}

	public ArrayList<Word> getWords() {
		return words;

	}


	public void setWords(final ArrayList<Word> words) {
		this.words = words;
	}

	public void setText(final String text) {
		this.text = text;
	}

	public int compareTo(Object obj) {
		Sentence tmp = (Sentence) obj;
		if (this.words.size() < tmp.words.size()) {
			return -1;
		} else if (this.words.size() > tmp.words.size()) {
			return 1;
		}
		return 0;
	}
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Sentence sentence = (Sentence) o;
		return Objects.equals(words, sentence.words) && Objects.equals(text, sentence.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(words, text);
	}


	@Override
	public String toString() {
		return text.toString() + "\n";
	}


}
