package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private final String name;
    private Key masterKey;
    private final List<String> inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
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

    /**
     * Adds an item to the player's satchel/inventory.
     */
    public void addItem(String itemName) {
        if (itemName != null && !itemName.isBlank()) {
            inventory.add(itemName);
        }
    }

    /**
     * Checks if the player is holding a specific item.
     */
    public boolean hasItem(String itemName) {
        return inventory.contains(itemName);
    }

    /**
     * Returns an unmodifiable list of inventory items.
     */
    public List<String> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}