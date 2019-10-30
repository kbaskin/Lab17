package co.grandcircus;

public class Country {

	private String name;
	private String population;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String name, String population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country name: " + name + ", population: " + population;
	}

}
