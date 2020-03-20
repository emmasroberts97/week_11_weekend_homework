import java.util.HashMap;

public class Card {

    private SuitType suit;
    private RankType rank;

    public Card(SuitType suit, RankType rank){
        this.suit = suit;
        this.rank = rank;
    }

    public SuitType getSuit(){
        return this.suit;
    }

    public RankType getRank(){
        return this.rank;
    }

    public HashMap<SuitType, Integer> getCardInformation(){
        HashMap<SuitType, Integer> cardInfo = new HashMap<SuitType, Integer>();
        cardInfo.put(this.suit, this.rank.getValue());
        return cardInfo;
    }

    public int getValueFromEnum(){
        return this.rank.getValue();
    }
}
