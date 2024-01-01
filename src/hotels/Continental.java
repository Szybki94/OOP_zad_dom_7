package hotels;

import assassins.Assassin;
import java.util.ArrayList;
import java.util.List;

public class Continental {
    private String managerNickName;
    private String managerPassword;
    private String location;
    private int availableRooms;
    private List<Assassin> assignedAssassins; // Lista przypisanych zabójców

    // Konstruktor klasy Continental
    public Continental(String managerNickName, String managerPassword, String location, int availableRooms) {
        this.managerNickName = managerNickName;
        this.managerPassword = managerPassword;
        this.location = location;
        this.availableRooms = availableRooms;
        this.assignedAssassins = new ArrayList<>(); // Inicjalizacja listy zabójców
    }

    // Metoda do przypisywania zabójcy do hotelu
    public void assignAssassin(Assassin assassin) {
        assignedAssassins.add(assassin);
        assassin.setHotel(this); // Ustawienie hotelu dla zabójcy
    }

    public void removeAssassin(Assassin assassin) {
        assignedAssassins.remove(assassin);
    }


}
