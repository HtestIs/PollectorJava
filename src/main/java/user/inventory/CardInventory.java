package user.inventory;

import card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class CardInventory {
    private final List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    public void addCard(Card card) {
        if (card != null) {
            this.cards.add(card);
        } else {
            throw new IllegalArgumentException("Unable to find the card");
        }
    }
}
