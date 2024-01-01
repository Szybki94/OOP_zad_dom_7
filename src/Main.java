import java.util.Scanner;

import assassins.*;
import hotels.Continental;
import managers.Manager;

public class Main {
    public static void main(String[] args) {
        // Inicjalizacja hoteli
        Continental hotelNewYork = new Continental("AJ", "admin1", "New York", 20);
        Continental hotelRome = new Continental("CM", "admin2", "Rome", 25);
        Continental hotelBeijing = new Continental("EW", "admin3", "Beijing", 30);

        // Inicjalizacja menedżerów
        Manager manager1 = new Manager("Alice", "Johnson", "AJ", "admin1");
        Manager manager2 = new Manager("Carlos", "Martinez", "CM", "admin2");
        Manager manager3 = new Manager("Elena", "Wang", "EW", "admin3");

        //Inicjalizacja zabójców
        Assassin silentAssassin = new SilentAssassin("John", "Smith", 30, "USA", new String[]{"English"}, "Ghost", "Lorem ipsum dolor sit amet...");
        Assassin poisoner = new Poisoner("Maria", "Gonzalez", 28, "Spain", new String[]{"Spanish", "English"}, "Viper", "Consectetur adipiscing elit...");
        Assassin sniper = new Sniper("Alex", "Ivanov", 35, "Russia", new String[]{"Russian", "English"}, "EagleEye", "Sed do eiusmod tempor incididunt...");
        Assassin demolitionExpert = new DemolitionExpert("Sam", "Johnson", 32, "UK", new String[]{"English"}, "Boom", "Ut labore et dolore magna aliqua...");

        // Meldowanie zabójców w hotelach
        hotelNewYork.assignAssassin(silentAssassin);
        hotelRome.assignAssassin(poisoner);
        hotelBeijing.assignAssassin(sniper);
        // Demolition expert nie jest przypisany celowo, żeby można było go zameldować przy użyciu programu.

        // Sterowanie programem
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Nickname: ");
        String inputNick = scanner.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = scanner.nextLine();

        boolean loginSuccess = false;
        // Zakładam, że manager1, manager2, manager3 są obiektami klasy Manager
        if ((inputNick.equals(manager1.getNickname()) && inputPassword.equals(manager1.getPassword())) ||
                (inputNick.equals(manager2.getNickname()) && inputPassword.equals(manager2.getPassword())) ||
                (inputNick.equals(manager3.getNickname()) && inputPassword.equals(manager3.getPassword()))) {
            loginSuccess = true;
            System.out.println("Logged in successfully.");
        }

        if (loginSuccess) {
            // Pętla główna programu
            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. List all managers");
                System.out.println("2. List all assassins");
                System.out.println("3. Send an assassin on a mission");
                System.out.println("4. Assign an assassin to a hotel");
                System.out.println("Type 'EXIT' to quit.");

                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("EXIT")) {
                    break;
                }

                switch (command) {
                    case "1":
                        Manager.listAllManagers();
                        break;
                    case "2":
                        Assassin.listAllAssassins();
                        break;
                    case "3":
                        Assassin.listAllAssassins();  // Lista zameldowanych zabójców
                        System.out.print("Enter Assassin ID to send on a mission: ");
                        int assassinId = scanner.nextInt();
                        scanner.nextLine();
                        Assassin selectedAssassin = Assassin.getAssassinById(assassinId);

                        if (selectedAssassin != null && selectedAssassin.getHotel() != null) {
                            Continental currentHotel = selectedAssassin.getHotel();
                            currentHotel.removeAssassin(selectedAssassin); // Wymeldowanie zabójcy
                            selectedAssassin.setHotel(null); // Usunięcie przypisania hotelu

                            System.out.print("Execute mission classically (1) or in their own way (2)? ");
                            int missionStyle = scanner.nextInt();
                            scanner.nextLine();
                            if (missionStyle == 1) {
                                selectedAssassin.executeTargetClassic();
                            } else {
                                selectedAssassin.executeTarget();
                            }
                        } else {
                            System.out.println("Invalid ID or assassin not assigned to any hotel.");
                        }
                        break;
                    case "4":
                        Assassin.listUnassignedAssassins();
                        System.out.print("Enter Assassin ID to assign to a hotel: ");
                        int unassignedAssassinId = scanner.nextInt();
                        scanner.nextLine();
                        Assassin unassignedAssassin = Assassin.getAssassinById(unassignedAssassinId);

                        if (unassignedAssassin == null) {
                            System.out.println("No assassin found with the given ID.");
                            break; // Wróć do głównej pętli
                        }

                        if (unassignedAssassin.getHotel() == null) {
                            // Wyświetl listę hoteli i zapytaj o wybór
                            System.out.println("Available Hotels: 1. New York 2. Rome 3. Beijing");
                            System.out.print("Choose a hotel (1-3): ");
                            int hotelChoice = scanner.nextInt();
                            scanner.nextLine();
                            // Hotele są zapisane na sztywno, nie chce mi się wprowadzać logiki podobnej do filtrowania
                            // managerów. Dowód na to, że potrafię już istnieje w klasie Manager :)
                            switch (hotelChoice) {
                                case 1:
                                    hotelNewYork.assignAssassin(unassignedAssassin);
                                    break;
                                case 2:
                                    hotelRome.assignAssassin(unassignedAssassin);
                                    break;
                                case 3:
                                    hotelBeijing.assignAssassin(unassignedAssassin);
                                    break;
                                default:
                                    System.out.println("Invalid hotel choice.");
                            }
                        } else {
                            System.out.println("Invalid Assassin ID or Assassin already assigned.");
                        }
                        break;
                    // inne metody gdyby trzeba było rozwijać kod
                }
            }
        } else {
            System.out.println("Invalid Nickname or Password.");
        }

    }
}
