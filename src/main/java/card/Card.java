package card;

public class Card {
    private int id;
    private String name;
    private Rarity rarity;
    private Edition edition;
    private String description;

    public Card(int id, String name, Rarity rarity, Edition edition, String description) {
        if(id < 0 || name == null || name.isEmpty() || description == null || description.isEmpty() || rarity == null || edition == null) {
            throw new IllegalArgumentException("Invalid card parameters");
        }
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.edition = edition;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Edition getEdition() {
        return edition;
    }
    public String getDescription() {
        return description;
    }
}
