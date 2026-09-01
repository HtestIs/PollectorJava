package user;

import pack.Pack;
import user.currencies.ShardPouch;
import user.inventory.CardInventory;
import user.inventory.ClueFragmentInventory;
import user.inventory.PackInventory;

public class User {
    private int id;
    private String name;
    private ShardPouch shards = new ShardPouch();
    private PackInventory packInventory = new PackInventory();
    private CardInventory cardInventory = new CardInventory();
    private ClueFragmentInventory clueFragmentInventory = new ClueFragmentInventory();
//    Constructor
    public User(int id, String name) {
        setId(id);
        setName(name);
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

//Shard Services

    public ShardPouch getShards() {
        return this.shards;
    }
    public boolean canAfford(Pack pack){
        if(pack == null)
            return false;
        return this.getShards().getShardBalance() >= pack.getPrice();
    }
    public boolean purchasePack(Pack pack){
        if(pack == null)
            return false;
        if(this.canAfford(pack)){
            this.getShards().spendShards(pack.getPrice());
            this.getPackInventory().addPackToInventory(pack);
            return true;
        }
        return false;
    }
//Pack Inventory
    public PackInventory getPackInventory() {
        return this.packInventory;
    }
//Card Inventory
    public CardInventory getCardInventory() {
        return this.cardInventory;
    }
//Clue Fragment Inventory
    public ClueFragmentInventory getClueFragmentInventory() {
        return this.clueFragmentInventory;
    }
}
