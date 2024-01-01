package assassins;

public class Poisoner extends Assassin {
    public Poisoner(String firstName, String nickname) {
        super(firstName, nickname);
    }

    public Poisoner(String firstName, String lastName, int age, String nationality, String[] languages, String nickname, String description) {
        super(firstName, lastName, age, nationality, languages, nickname, description);
    }

    @Override
    public void executeTarget() {
        System.out.println("Przynajmniej było smacznie.");
    }
}
