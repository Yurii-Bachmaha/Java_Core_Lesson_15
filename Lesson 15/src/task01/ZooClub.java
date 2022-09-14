package task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ZooClub {

	Scanner scanner = new Scanner(System.in);
	Map<Person, ArrayList<Animal>> map = new HashMap<Person, ArrayList<Animal>>();

	public void addMemberToClub() {
		scanner = new Scanner(System.in);
		System.out.println("Adding a member to the club");

		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter age:");
		int age = scanner.nextInt();

		Person ZooClubMember = new Person(name, age);
		map.put(ZooClubMember, new ArrayList<Animal>());
		System.out.println(ZooClubMember.toString() + " now in the club.");
	}

	public void addAnimalToClubMember() {
		System.out.println("Adding animal to club member");
		scanner = new Scanner(System.in);

		System.out.println("Enter person name:");
		String name = scanner.next();
		System.out.println("Enter person age:");
		int age = scanner.nextInt();

		boolean check = isMemberPresent(map, name, age);

		if (check) {
			scanner = new Scanner(System.in);
			System.out.println("Enter animal type:");
			String animalType = scanner.next();
			System.out.println("Enter animal name:");
			String animalName = scanner.next();

			Animal animal = new Animal(animalType, animalName);

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();
				if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
					ArrayList<Animal> list = next.getValue();

					list.add(animal);
					System.out.println(animal + " is successfully added.");
				}
			}
		} else {
			System.out.println("There is no club member with that name.");
		}
	}

	public void removeAnimalFromClubMember() {
		System.out.println("Removing animal from club member");
		scanner = new Scanner(System.in);

		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter age:");
		int age = scanner.nextInt();

		boolean check = isMemberPresent(map, name, age);

		if (check) {
			scanner = new Scanner(System.in);

			System.out.println("Enter animal type:");
			String animalType = scanner.next();
			System.out.println("Enter animal name:");
			String animalName = scanner.next();

			boolean check2 = isAnimalPresent(map, name, age, animalType, animalName);

			if (check2) {
				Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> next = iterator.next();

					if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
						ArrayList<Animal> list = next.getValue();

						Iterator<Animal> iterator2 = list.iterator();
						while (iterator2.hasNext()) {
							Animal next2 = iterator2.next();

							if (next2.getAnimalType().equalsIgnoreCase(animalType)
									&& next2.getAnimalName().equalsIgnoreCase(animalName)) {
								iterator2.remove();
								System.out.println(
										next2.toString() + " is successfully removed from " + next.getKey().toString());
							}
						}
					}
				}
			} else {
				System.out.println("There is no animal with that name");
			}
		} else {
			System.out.println("There is no member in club with that name");
		}
	}

	public void removeMemberFromClub() {
		System.out.println("Removing member from club");
		scanner = new Scanner(System.in);

		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter age:");
		int age = scanner.nextInt();

		boolean check = isMemberPresent(map, name, age);

		if (check) {
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();
				if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
					iterator.remove();
					System.out.println(next.getKey().toString() + " is successfully removed.");
				}
			}
		} else {
			System.out.println("There is no member in club with that name");
		}
	}

	public void removeSpecificAnimalFromAllMembers() {
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

		if (!iterator.hasNext()) {
			System.out.println("ZooClub is empty");
		} else {
			scanner = new Scanner(System.in);
			System.out.println("Enter animal type:");
			String animalType = scanner.next();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();
				ArrayList<Animal> list = next.getValue();
				Iterator<Animal> iterator2 = list.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();
					if (next2.getAnimalType().equalsIgnoreCase(animalType)) {
						iterator2.remove();
						System.out.println("All animals with type " + next2.getAnimalType() + " is removed.");
					} else if (!(next2.getAnimalType().equalsIgnoreCase(animalType))) {
						System.out.println("There is no animal with that type.");
					}
				}
			}if(!iterator.hasNext()) {
				System.out.println("ZooClub is empty");
			}
		}
	}

	public void showZooClub() {
		Set<Entry<Person, ArrayList<Animal>>> entrySet = map.entrySet();
		if (entrySet.isEmpty()) {
			System.out.println("ZooClub is empty");
		} else {
			System.out.println("All club:");
		}

		for (Entry<Person, ArrayList<Animal>> entry : entrySet) {
			System.out.println(entry.getKey() + "" + entry.getValue());
		}
	}

	static boolean isMemberPresent(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
		boolean flag = false;

		Set<Entry<Person, ArrayList<Animal>>> entrySet = zooClub.entrySet();

		for (Entry<Person, ArrayList<Animal>> entry : entrySet) {
			if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
				flag = true;
			}
		}

		return flag;
	}

	static boolean isAnimalPresent(Map<Person, ArrayList<Animal>> map, String name, int age, String animalType,
			String animalName) {
		boolean flag = false;

		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();

			if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
				ArrayList<Animal> list = next.getValue();

				Iterator<Animal> iterator2 = list.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();

					if (next2.getAnimalType().equalsIgnoreCase(animalType)
							&& next2.getAnimalName().equalsIgnoreCase(animalName)) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}
}