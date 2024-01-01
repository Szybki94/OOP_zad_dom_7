package assassins;

public class Sniper extends Assassin {
    public Sniper(String firstName, String nickname) {
        super(firstName, nickname);
    }

    public Sniper(String firstName, String lastName, int age, String nationality, String[] languages, String nickname, String description) {
        super(firstName, lastName, age, nationality, languages, nickname, description);
    }

    @Override
    public void executeTarget() {
        System.out.println("A mówili, że nie da się tworzyć związków na odległość.");
    }
}
