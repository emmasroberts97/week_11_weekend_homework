import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player emma;
    private Player francesca;
    private Player joe;
    private Dealer dealer;
    private Card card1;
    private Card card2;
    private Card ace;

    @Before
    public void before(){
        dealer = new Dealer();
        game = new Game(dealer);
        emma = new Player("Emma");
        francesca = new Player("Francesca");
        joe = new Player("Joe");
        card2 = new Card(SuitType.CLUBS, RankType.TEN);
        card1 = new Card(SuitType.DIAMONDS, RankType.FIVE);
        ace = new Card(SuitType.SPADES, RankType.ACE);



        game.addPlayer(emma);
        game.addPlayer(francesca);
        game.addPlayer(joe);
    }

    @Test
    public void canAddPlayers(){
        assertEquals(3, game.getPlayerCount());
    }

    @Test
    public void canSetUpGame(){
        game.setUpGame();
        int dealerSize = dealer.getDealerCards().size();
        assertEquals(2, dealerSize);
        assertEquals(2, emma.getCardsCount());

    }

    @Test
    public void canGetPlayerTotal(){
       emma.getHand(card1);
       emma.getHand(card2);

       Integer expected = 15;
       Integer value = game.getPlayerValues(emma);

       assertEquals(expected, value);
    }

    @Test
    public void canGetDealerTotal(){
        dealer.addCardToDealer(card1);
        dealer.addCardToDealer(card2);

        Integer expected = 15;
        Integer value = game.getDealerValues();

        assertEquals(expected, value);
    }

    @Test
    public void playerCanWin(){
        emma.getHand(card2);
        emma.getHand(card2);
        dealer.addCardToDealer(card1);
        dealer.addCardToDealer(card1);

        assertEquals("Player wins!", game.playGame(emma));
    }

    @Test
    public void dealerCanWin(){
        dealer.addCardToDealer(card2);
        dealer.addCardToDealer(card2);
        emma.getHand(card1);
        emma.getHand(card1);

        assertEquals("Dealer wins!", game.playGame(emma));
    }

    @Test
    public void playerGetsMoreThan21(){
        emma.getHand(card2);
        emma.getHand(card2);
        emma.getHand(card1);

        dealer.addCardToDealer(card2);
        dealer.addCardToDealer(card2);

        assertEquals("Dealer wins!", game.playGame(emma));
    }

    @Test
    public void dealerGetsMoreThan21(){
        dealer.addCardToDealer(card2);
        dealer.addCardToDealer(card2);
        dealer.addCardToDealer(card1);

        emma.getHand(card2);
        emma.getHand(card1);

        assertEquals("Player wins!", game.playGame(emma));
    }

    @Test
    public void playerCanTwist(){
        emma.getHand(card2);
        emma.getHand(card1);

        game.playerDecidesTwist(emma);

        assertEquals(3, emma.getCardsCount());
    }

    @Test
    public void dealerCanTwist(){
        dealer.addCardToDealer(card2);
        dealer.addCardToDealer(card1);

        game.dealerDecidesTwist();

        assertEquals(3, dealer.getDealerCards().size());
    }

    @Test
    public void canHaveBlackJack(){
        dealer.addCardToDealer(ace);
        dealer.addCardToDealer(card2);

        assertEquals(true, game.checkDealerBlackjack());

        emma.getHand(ace);
        emma.getHand(card1);

        assertEquals(false, game.checkPlayerBlackjack(emma));
    }

}
