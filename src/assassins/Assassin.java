package assassins;

import java.util.ArrayList;
import java.util.List;
import hotels.Continental;

public abstract class Assassin {
    private static int nextId = 0;
    private static List<Assassin> allAssassins = new ArrayList<>();

    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private String[] languages;
    private String nickname;
    private String description;

    private Continental hotel;

    {
        id = nextId++;
        allAssassins.add(this);
    }

    public static void listAllAssassins() {
        for (Assassin assassin : allAssassins) {
            System.out.println("ID: " + assassin.id + ", Nickname: " + assassin.nickname);
        }
    }

    // Konstruktor podstawowy
    public Assassin(String firstName, String nickname) {
        this.firstName = firstName;
        this.nickname = nickname;
    }

    // Konstruktor przeciążony z wszystkimi atrybutami
    public Assassin(String firstName, String lastName, int age, String nationality, String[] languages, String nickname, String description) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.languages = languages;
        this.nickname = nickname;
        this.description = description;
    }

    // Getter dla hotelu
    public Continental getHotel() {
        return hotel;
    }

    public static void listUnassignedAssassins() {
        for (Assassin assassin : allAssassins) {
            if (assassin.getHotel() == null) {
                System.out.println("ID: " + assassin.id + ", Name: " + assassin.firstName + " " + assassin.lastName + ", Nickname: " + assassin.nickname);
            }
        }
    }


    // Metoda do przypisania zabójcy do hotelu
    public void setHotel(Continental hotel) {
        this.hotel = hotel;
    }

    // Metoda abstrakcyjna do wykonania zlecenia
    public abstract void executeTarget();

    // Metoda do wykonania zlecenia w sposób klasyczny
    public void executeTargetClassic() {
        System.out.println("Zlecenie wykonano w sposób klasyczny.");
    }

    // Szykanie zabójcy po id
    public static Assassin getAssassinById(int id) {
        for (Assassin assassin : allAssassins) {
            if (assassin.id == id) {
                return assassin;
            }
        }
        return null;
    }
}
