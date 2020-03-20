import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private ArrayList<Card> dealerCards;

    public Dealer(){

        this.deck = new Deck();
        this.dealerCards = new ArrayList<Card>();

        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public Card dealCard(){
        return this.deck.dealRandomCard();
    }

    public void addCardToDealer(Card card){
        this.dealerCards.add(card);
    }

    public ArrayList<Card> getDealerCards(){
        return this.dealerCards;
    }

    public Integer showHand(Card card){
        int index = this.dealerCards.indexOf(card);
        Card chosenCard = this.dealerCards.get(index);
        return chosenCard.getCardInformation().get(card.getSuit());
    }
}
