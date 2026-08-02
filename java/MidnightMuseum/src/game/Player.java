package game;

public class Player {

    private final String name;
    private Key masterKey;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveKey(Key key) {
        this.masterKey = key;
    }

    public Key getKey() {
        return masterKey;
    }

    public boolean hasKey() {
        return masterKey != null;
    }
}