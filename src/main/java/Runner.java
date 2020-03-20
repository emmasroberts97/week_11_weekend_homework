import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dealer dealer = new Dealer();

        Game game = new Game(dealer);

        System.out.println("Welcome to Blackjack!");
        System.out.println("What is you name?");

        String input = scanner.next();
        Player player = new Player(input);
        game.addPlayer(player);

        game.setUpGame();

        if (game.checkPlayerBlackjack(player) || game.checkDealerBlackjack()){
            String output = String.format("%s has: ", player.getName());
            System.out.println(output);

            for (int i=0; i < player.getCardsCount(); i++){
                System.out.println(String.format("%s of %s", player.showCard(i).getRank(), player.showCard(i).getSuit()));
            }
            game.dealerDecidesTwist();
            System.out.println(String.format("%s's Hand Total: %s", player.getName(), game.getPlayerValues(player)));
            System.out.println(String.format("Dealer's Hand Total: %s", game.getDealerValues()));
            System.out.println(game.playGame(player));

        } else {
            String output = String.format("%s has: ", player.getName());
            System.out.println(output);

            for (int i = 0; i < player.getCardsCount(); i++) {
                System.out.println(String.format("%s of %s", player.showCard(i).getRank(), player.showCard(i).getSuit()));
            }

            System.out.println(String.format("Hand Total: %s", game.getPlayerValues(player)));

            while (game.getPlayerValues(player) < 21) {
                System.out.println("Would you like to twist? yes/no");

                String choice = scanner.next();

                if (choice.equals("yes")) {
                    game.playerDecidesTwist(player);
                    if (game.getPlayerValues(player) >= 21) {
                        game.dealerDecidesTwist();
                        System.out.println(String.format("%s's Hand Total: %s", player.getName(), game.getPlayerValues(player)));
                        System.out.println(String.format("Dealer's Hand Total: %s", game.getDealerValues()));
                        System.out.println(game.playGame(player));
                        break;
                    } else {
                        for (int i=0; i < player.getCardsCount(); i++){
                            System.out.println(String.format("%s of %s", player.showCard(i).getRank(), player.showCard(i).getSuit()));
                        }
                        System.out.println(String.format("%s's Hand Total: %s", player.getName(), game.getPlayerValues(player)));
                    }

                } else {
                    game.dealerDecidesTwist();
                    System.out.println(String.format("%s's Hand Total: %s", player.getName(), game.getPlayerValues(player)));
                    System.out.println(String.format("Dealer's Hand Total: %s", game.getDealerValues()));
                    System.out.println(game.playGame(player));
                    break;
                }


            }
        }


    }
}
