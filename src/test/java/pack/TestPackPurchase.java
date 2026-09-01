package pack;
import org.testng.annotations.Test;
import org.testng.Assert;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class TestPackPurchase {
    @Test
    public void testPackAffordable(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(1,"Agony Paradise",200,"p...........a..i.n.......");
        boolean result = player.canAfford(pack);
        Assert.assertFalse(result);
    }
    @Test
    public void testPackAffordable2(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        boolean result = player.canAfford(null);
        Assert.assertFalse(result);
    }
    @Test
    public void testPurchasingPack(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(1,"The Covenant",25, "Old Ones Are Watching....");
        Assert.assertTrue(player.purchasePack(pack));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp-pack.getPrice());
    }
    @Test
    public void testPurchasingPack2(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(2,"Castle Of Gold",170,"The battle you can not afford!!");
        Assert.assertFalse(player.purchasePack(pack));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
    }
    @Test
    public void testPurchasingPack3(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Assert.assertFalse(player.purchasePack(null));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
    }
    @Test
    public void testPurchasingPackList(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(1,"The Tyrant",50,"The King fights this own battle!!");
        Assert.assertTrue(player.purchasePack(pack));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp-pack.getPrice());
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        Assert.assertEquals(packs.size(),1);
        Assert.assertEquals(packs.getFirst(),pack);
    }
    @Test
    public void testPurchasingPackListFail(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(1,"The Tyrant",150,"The King fights this own battle!!");
        Assert.assertFalse(player.purchasePack(pack));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        Assert.assertEquals(packs.size(),0);
    }
    @Test
    public void testPurchasingPackListNull(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Assert.assertFalse(player.purchasePack(null));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp);
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        Assert.assertEquals(packs.size(),0);
    }
    @Test
    public void testPurchasingPackList2(){
        int firstTopUp = 100;
        User player = new User(1,"Hieu");
        player.getShards().addShard(firstTopUp);
        Pack pack = new Pack(1,"The Tyrant",50,"The King fights this own battle!!");
        Pack pack2 = new Pack(2,"The Crimson Queen",25,"Let the world burn!!!");
        Assert.assertTrue(player.purchasePack(pack));
        Assert.assertTrue(player.purchasePack(pack2));
        Assert.assertEquals(player.getShards().getShardBalance(),firstTopUp-pack.getPrice()-pack2.getPrice());
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        Assert.assertEquals(packs.size(),2);
        Assert.assertEquals(packs.getFirst(),pack);
        Assert.assertEquals(packs.get(1),pack2);
    }
    @Test
            (
                    expectedExceptions = UnsupportedOperationException.class
            )
    public void testModifyingPack(){
        User player = new User(1,"Hieu");
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        packs.clear();
    }
    @Test
    public void testModifyingPack2(){
        User player = new User(1,"Hieu");
        List<Pack> packs = player.getPackInventory().getOwnedPacks();
        Assert.assertEquals(packs.size(),0);
    }
}
