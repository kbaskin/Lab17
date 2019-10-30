package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {


//contains a method that allows you to read a list of countries from a file 
	public static ArrayList<Country> readFromFile(String fileName) {
		ArrayList<Country> countries = new ArrayList<>();
		Path path = Paths.get(fileName);

		File file = path.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			while (line != null) {
				// 1.
				String[] countryList = line.split(",");
				// 2.
				Country c = new Country(countryList[0], countryList[1]);
				// 3.
				countries.add(c);
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Something happened with the file...");
		} catch (IOException e) {
			System.out.println("Something happened when attempting to read from the file...");
		}
		return countries;
	}

	// method that allows you to write a list of countries to a file
	// store the list of countries in a text file named countries.txt
	public static void writeToFile(ArrayList<Country> country) {
		String fileName = "countries.txt";

		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			for (Country c : country) {
				output.println(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");
		} finally {
			output.close();
		}

	}

	// store the list of countries in a text file named countries.txt in the same
	// directory as the CountriesTextFile class
	// if the countries.txt file doesn't exist, CountriesTextFile should create it
	public static void createOurFile() { // could make dynamic by passing in parameter

		String fileName = "countries.txt";

		Path path = Paths.get(fileName); // put countries.txt in the main java project

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				// System.out.println("File was created successfully!"); // put a sysout in to
				// let user know
			} catch (IOException e) {
				System.out.println("Something went terribly wrong.");
			}
		} else { // add this else after the try catch
			// System.out.println("The folder already exists.");
		}

	}

}
