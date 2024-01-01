package assassins;

public class SilentAssassin extends Assassin {
    public SilentAssassin(String firstName, String nickname) {
        super(firstName, nickname);
    }

    public SilentAssassin(String firstName, String lastName, int age, String nationality, String[] languages, String nickname, String description) {
        super(firstName, lastName, age, nationality, languages, nickname, description);
    }

    @Override
    public void executeTarget() {
        System.out.println("Nikt nic nie widział, nikt nic nie słyszał...");
    }
}
