package card;

import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;

import java.util.List;

public class TestUserCard {
    @Test
    public void testAddCard()
    {
        User player = new User(1,"Hieu");
        Card card = new Card(1,"Priestess under the Star",Rarity.LEGACY,Edition.PRISMATIC,"Starlight gazes upon");
        player.getCardInventory().addCard(card);
        List<Card> cards = player.getCardInventory().getCards();
        Assert.assertEquals(cards.get(0),card);
    }
    @Test
            (
                    expectedExceptions = UnsupportedOperationException.class
            )
    public void testAddCardInvalid()
    {
        User player = new User(1,"Hieu");
        Card card = new Card(1,"Priestess under the Star",Rarity.LEGACY,Edition.PRISMATIC,"Starlight gazes upon");
        player.getCardInventory().getCards().add(card);
    }
    @Test
            (
                    expectedExceptions = UnsupportedOperationException.class
            )
    public void testClearCardInvalid()
    {
        User player = new User(1,"Hieu");
        Card card = new Card(1,"Priestess under the Star",Rarity.LEGACY,Edition.PRISMATIC,"Starlight gazes upon");
        player.getCardInventory().getCards().clear();
    }
}
