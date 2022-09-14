package task01;

import java.util.Objects;

public class Animal {

	private String animalType;
	private String animalName;

	public Animal(String animalType, String animalName) {
		super();
		this.animalType = animalType;
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(animalName, animalType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(animalName, other.animalName) && Objects.equals(animalType, other.animalType);
	}

	@Override
	public String toString() {
		return "Animal: [animalType=" + animalType + ", animalName=" + animalName + "]";
	}
}