import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deckOfCards;
    private SuitType[] suits;
    private RankType[] ranks;
    private Random random;

    public Deck(){
        this.deckOfCards = new ArrayList<Card>();
        this.suits = SuitType.values();
        this.ranks = RankType.values();
        this.random = new Random();
    }

    public void populateDeck(){
        for (SuitType type : this.suits){
            for (RankType rank : this.ranks){
                Card newCard = new Card(type, rank);
                this.deckOfCards.add(newCard);
            }
        }
    }

    public ArrayList<Card> getDeck(){
        return this.deckOfCards;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deckOfCards);
    }

    public Card dealRandomCard(){
       return this.deckOfCards.get(this.random.nextInt(this.deckOfCards.size()));
    }

}
