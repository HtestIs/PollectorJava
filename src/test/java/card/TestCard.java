package card;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCard {
    @Test
    public void testCardValidation()
    {
        Card card = new Card(1,"Knight of Moonlight",Rarity.RARE,Edition.PRISMATIC,"Lover of Moonlight");
        Assert.assertEquals(card.getId(), 1);
        Assert.assertEquals(card.getName(), "Knight of Moonlight");
        Assert.assertEquals(card.getRarity(), Rarity.RARE);
        Assert.assertEquals(card.getEdition(), Edition.PRISMATIC);
        Assert.assertEquals(card.getDescription(), "Lover of Moonlight");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidId()
    {
        Card card = new Card(-1,"Knight of Moonlight",Rarity.RARE,Edition.PRISMATIC,"Lover of Moonlight");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidName()
    {
        Card card = new Card(1,null,Rarity.RARE,Edition.PRISMATIC,"L*v#r ^f M**nl!g(t");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidName2()
    {
        Card card = new Card(1,"",Rarity.RARE,Edition.PRISMATIC,"L*v#r ^f M**nl!g(t");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidRarity()
    {
        Card card = new Card(1,"Eclipse Preacher",null,Edition.PRISMATIC,"None has reach the moment");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidEdition()
    {
        Card card = new Card(1,"Eclipse Preacher",Rarity.LEGACY,null,"None has reach the moment");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidDescription()
    {
        Card card = new Card(1,"Starlight Wanderer",Rarity.LEGACY,Edition.PRISMATIC,"");
    }
    @Test
            (
                    expectedExceptions = IllegalArgumentException.class,
                    expectedExceptionsMessageRegExp = "Invalid card parameters"
            )
    public void testCardInvalidDescription2()
    {
        Card card = new Card(1,"Starlight Wanderer",Rarity.LEGACY,Edition.PRISMATIC,null);
    }
}
