package com.epam.jwd.task2.reader;

import com.epam.jwd.task2.printer.Printer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	public static BufferedReader reader() throws FileNotFoundException {
		try {
			File file = new File("myFile.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			Printer.printStringLn("Error: " + e);
		}

		return new BufferedReader(new FileReader("myFile.txt"));

	}
}
