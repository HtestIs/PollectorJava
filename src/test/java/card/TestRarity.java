package card;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRarity {
    @Test
    public void testRarity(){
        Rarity rarity = Rarity.RARE;
        Assert.assertEquals(rarity,Rarity.RARE);
    }
    @Test
    public void testEdition(){
        Edition edition = Edition.NORMAL;
        Assert.assertEquals(edition,Edition.NORMAL);
    }
}
