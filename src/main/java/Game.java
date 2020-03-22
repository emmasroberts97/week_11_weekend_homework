import java.util.ArrayList;

public class Game {

    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Dealer dealer){
        this.dealer = dealer;
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public int getPlayerCount(){
        return this.players.size();
    }

    public void setUpGame(){
        Card dealerCard1 = dealer.dealCard();
        dealer.addCardToDealer(dealerCard1);
        Card dealerCard2 = dealer.dealCard();
        dealer.addCardToDealer(dealerCard2);
        for (Player player : this.players){
            Card card1 = this.dealer.dealCard();
            player.getHand(card1);
            Card card2 = this.dealer.dealCard();
            player.getHand(card2);
        }
    }

    public String playGame(Player player){
        String result = "test";
        if (checkPlayerBlackjack(player)){
            result = "Player wins!";
        } else if (checkDealerBlackjack()){
            result = "Dealer wins!";
        } else if (getPlayerValues(player) > getDealerValues() && getPlayerValues(player) <= 21){
            result = "Player wins!";
        } else if (getDealerValues() > getPlayerValues(player) && getDealerValues() <= 21){
            result = "Dealer wins!";
        } else if (getDealerValues() > 21 && getPlayerValues(player) <= 21){
            result = "Player wins!";
        } else if (getPlayerValues(player) > 21 && getDealerValues() <= 21){
            result = "Dealer wins!";
        } else if (getPlayerValues(player).equals(getDealerValues())){
            result = "It's a draw";
        } else if (getPlayerValues(player) > 21 && getDealerValues() > 21){
            result = "No one wins!";
        }
        return result;
    }

    public Integer getPlayerValues(Player player){
        Integer total = 0;
        for (Card card : player.getCards()){
             total += player.showHand(card);
        }
        if (total > 21 && player.containsAce()){
            total -= 10;
        }
        return total;
    }

    public Integer getDealerValues(){
        Integer total = 0;
        for (Card card : dealer.getDealerCards()){
            total += dealer.showHand(card);
        }
        if (total > 21 && dealer.containsAce()){
            total -= 10;
        }
        return total;
    }


    public void playerDecidesTwist(Player player){
        Card newCard = dealer.dealCard();
        player.getHand(newCard);
    }

    public void dealerDecidesTwist(){
        while (getDealerValues() < 16) {
            Card newCard = dealer.dealCard();
            dealer.addCardToDealer(newCard);
        }
    }

    public Boolean checkPlayerBlackjack(Player player){
        Boolean result;
        if (player.getCardsCount() == 2 && getPlayerValues(player) == 21){
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public Boolean checkDealerBlackjack(){
        Boolean result;
        if (dealer.getDealerCards().size() == 2 && getDealerValues() == 21){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
