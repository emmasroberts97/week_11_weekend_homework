import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;
    private String name;

    public Player(String name){
        this.hand = new ArrayList<Card>();
        this.name = name;
    }

    public void getHand(Card card){
        this.hand.add(card);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer showHand(Card card){
        int index = this.hand.indexOf(card);
        Card chosenCard = this.hand.get(index);
        return chosenCard.getCardInformation().get(card.getSuit());
    }

    public int getCardsCount(){
       return this.hand.size();
    }

    public ArrayList<Card> getCards(){
        return this.hand;
    }

    public Card showCard(int index){
        Card chosenCard = this.hand.get(index);
        return chosenCard;
    }
}
