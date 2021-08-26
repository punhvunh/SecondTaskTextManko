package com.epam.jwd.task2.components;

import com.epam.jwd.task2.printer.Printer;

import java.util.Objects;

public class Word {
	private String text;
	private boolean specialSymbols;

	public Word(String text){
		this.text = text;
		if(text.matches("([\u2026\u002E,!?;:()])")){
			specialSymbols = true;
			Printer.printString(this.text);
		}
		else {
			specialSymbols = false;
			Printer.printString(" " + this.text);
		}

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSpecialSymbols() {
		return specialSymbols;
	}

	public void setSpecialSymbols(boolean specialSymbols) {
		this.specialSymbols = specialSymbols;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Word word = (Word) o;
		return specialSymbols == word.specialSymbols && Objects.equals(text, word.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(text, specialSymbols);
	}

	@Override
	public String toString() {
		return  text.toString();

	}
}
