package task01;

import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("Enter 1 to add member to club." + "\nEnter 2 to add animal to member."
				+ "\nEnter 3 to remove animal from club member" + "\nEnter 4 to remove club member from club"
				+ "\nEnter 5 to remove specific animal from all members." + "\nEnter 6 to output ZooClub."
				+ "\nEnter 7 to exit the program.");
	}

	public static void main(String[] args) {

		ZooClub zooClub = new ZooClub();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();

			switch (scanner.next()) {

			case "1": {
				zooClub.addMemberToClub();
				break;
			}

			case "2": {
				zooClub.addAnimalToClubMember();
				break;
			}

			case "3": {
				zooClub.removeAnimalFromClubMember();
				break;
			}

			case "4": {
				zooClub.removeMemberFromClub();
				break;
			}

			case "5": {
				zooClub.removeSpecificAnimalFromAllMembers();
				break;
			}

			case "6": {
				zooClub.showZooClub();
				break;
			}

			case "7": {
				System.exit(0);
				scanner.close();
				break;
			}
			}
		}
	}
}