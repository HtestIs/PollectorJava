package pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPack {
    @Test
    public void TestPackCreating() {
        Pack firstPack = new Pack(1,"Frozen Castle",50,"Winter is coming!!!!!");
        Assert.assertEquals(firstPack.getName(),"Frozen Castle");
        Assert.assertEquals(firstPack.getPrice(),50);
    }
    @Test
    public void testAddingWithoutPrice() {
        Pack firstPack = new Pack(1,"Dark Woods","The forest foresees~~~");
        Assert.assertEquals(firstPack.getName(),"Dark Woods");
        Assert.assertEquals(firstPack.getPrice(),0);
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "The price must be higher or equal 0"
    )
    public void testAddingWithNegativePrice() {
        Pack firstPack = new Pack(1,"Sea Worlds",-50,"Fear the deep....");
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Pack must have a name"
    )
    public void testAddingInvalidName() {
        Pack firstPack = new Pack(1,"",50,"The forest foresees");
    }
    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Pack must have a name"
    )
    public void testAddingInvalidName2() {
        Pack firstPack = new Pack(1,null,50,"The forest foresees");
    }

}
