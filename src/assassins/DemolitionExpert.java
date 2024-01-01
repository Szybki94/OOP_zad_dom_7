package assassins;

public class DemolitionExpert extends Assassin {
    public DemolitionExpert(String firstName, String nickname) {
        super(firstName, nickname);
    }

    public DemolitionExpert(String firstName, String lastName, int age, String nationality, String[] languages, String nickname, String description) {
        super(firstName, lastName, age, nationality, languages, nickname, description);
    }

    @Override
    public void executeTarget() {
        System.out.println("C4??? Brzmi zdecydowanie lepiej od D'dur");
    }
}
