package user;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShardServices {
    @Test
    public void testAddingValidShard(){
        int shardAmount = 500;
        User player = new User(1,"Hieu");
        player.getShards().addShard(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),shardAmount);
    }
    @Test
    public void testSpendingValidShard(){
        int shardAmount = 500;
        int firstTopUp = 500;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        player.getShards().spendShards(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(), 0);
    }
    @Test
    public void testSpendingValidShard2(){
        int shardAmount = 500;
        int firstTopUp = 800;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        player.getShards().spendShards(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(), firstTopUp-shardAmount);
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The amount of adding shards can not be lower than 1"
            )
    public void testAddingZeroShard(){
        int shardAmount = 0;
        User player = new User(1,"Hieu");
        player.getShards().addShard(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),0);
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The amount of adding shards can not be lower than 1"
    )
    public void testAddingNegativeShard(){
        int shardAmount = -1;
        User player = new User(1,"Hieu");
        player.getShards().addShard(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),0);
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The amount of spending shards can not be lower than 1"
    )
    public void testSpendingZeroShards(){
        int shardAmount = 0;
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        player.getShards().spendShards(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The amount of spending shards can not be lower than 1"
    )
    public void testSpendingNegativeShards(){
        int shardAmount = -10;
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        player.getShards().spendShards(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The amount of spending shards can not be higher than current balance"
    )
    public void testSpendingMoreThanCurrentBalance(){
        int shardAmount = 500;
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        player.getShards().spendShards(shardAmount);
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
    }
}
