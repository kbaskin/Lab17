package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int menu;
		CountriesTextFile.createOurFile();
		ArrayList<Country> countryList = new ArrayList<>();
		countryList.add(new Country("India", "1,339,000,000"));
		countryList.add(new Country("The United States", "325,700,000"));
		countryList.add(new Country("China", "1,386,000,000"));
		countryList.add(new Country("Rwanda", "12,210,000"));

		System.out.println("Welcome to the Countries Maintenance Application!\nLet's learn!");

		do {
			// displays a menu and responds to user choices
			// use validator
			menu = Validator.getInt(scan,
					"\n1. See the list of countries\n2. Add a country\n3. Delete a country from list\n4. Exit\n\nEnter menu number: \n",
					1, 4);

			if (menu == 1) {
				// list all countries
				CountriesTextFile.writeToFile(countryList);
				ArrayList<Country> countriesFromFile = CountriesTextFile.readFromFile("countries.txt");
				CountriesTextFile.readFromFile("countries.txt");

				for (Country c1 : countryList) {
					System.out.println(c1);
				}

			} else if (menu == 2) {
				// add a country
				System.out.println("Enter country name: ");
				String name = scan.nextLine();
				System.out.println("Enter population: ");
				String pop = scan.nextLine();

				Country c1 = new Country(name, pop);
				countryList.add(c1);
				CountriesTextFile.writeToFile(countryList);
				System.out.println("\nYou country has been added!");

			} else if (menu == 3) {
				// extended challenge - delete a country from list
				for (int i = 0; i < countryList.size(); i++) {
					System.out.println((i + 1) + ". " + countryList.get(i));
				}
				int deleteTask = Validator.getInt(scan, "\nWhich country would you like to delete?", 1,
						countryList.size());
				deleteTask = deleteTask - 1;
				String confirmDelete = Validator.getString(scan,
						"\nAre you sure you want to delete this country? (y/n)");
				if ((confirmDelete.equalsIgnoreCase("yes")) || (confirmDelete.equalsIgnoreCase("y"))) {
					countryList.remove(deleteTask);
					System.out.println("\nCountry was deleted.");
					continue;
				} else {
					continue;
				}

			} else { // exit
				break;
			}

		} while (menu != 4);

		System.out.println("I hope you learned something new! Goodbye!");

	}

}
