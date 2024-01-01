package managers;

import java.util.ArrayList;
import java.util.List;

// Te klasę można traktować jako przykład enkapsulacji. Występują tutaj prywatne atrybutu oraz metody zapewniające
// do nich dostęp

public class Manager {
    private static List<Manager> allManagers = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String nickname;
    private String password;

    public Manager(String firstName, String lastName, String nickname, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.password = password;
        allManagers.add(this);
    }

    // Getter dla pseudonimu
    public String getNickname() {
        return nickname;
    }

    // Getter dla hasła
    public String getPassword() {
        return password;
    }

    public static void listAllManagers() {
        for (Manager manager : allManagers) {
            System.out.println("Name: " + manager.firstName + " " + manager.lastName + ", Nickname: " + manager.nickname);
        }
    }

    // Wyświetlanie info o menagerze
    public void displayInfo() {
        System.out.println("Name: " + firstName + " " + lastName + ", Nickname: " + nickname);
    }


}
