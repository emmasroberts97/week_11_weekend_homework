import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void canPopulate(){
        deck.populateDeck();
        assertEquals(52, deck.getDeck().size());
    }

    @Test
    public void canShuffle(){
        deck.populateDeck();
        Card card1 = deck.getDeck().get(0);
        System.out.println(card1);
        deck.shuffleDeck();
        Card card2 = deck.getDeck().get(0);
        System.out.println(card2);

        assertNotEquals(card2, card1);
    }

    @Test
    public void canGetRandom(){
        deck.populateDeck();
        deck.shuffleDeck();
        Card card1 = deck.dealRandomCard();
        System.out.println(card1);
        Card card2 = deck.dealRandomCard();
        System.out.println(card2);


    }

}
