package pack;

public class Pack {
    private int id;
    private String name;
    private int price;
    private String description;
    public Pack(int id, String name, int price, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Pack must have a name");
        }
        if (price < 0) {
            throw new IllegalArgumentException("The price must be higher or equal 0");
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public Pack(int id, String name, String description) {
        this(id, name, 0, description);
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
}
