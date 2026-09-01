package user.currencies;


public class ShardPouch {
    private int shards;
    public int getShardBalance(){
        return this.shards;
    }
    public void addShard(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("The amount of adding shards can not be lower than 1");
        }
        this.shards += amount;
    }
    public void spendShards(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("The amount of spending shards can not be lower than 1");
        }
        if(amount > this.shards){
            throw new IllegalArgumentException("The amount of spending shards can not be higher than current balance");
        }
        this.shards -= amount;
    }

}
