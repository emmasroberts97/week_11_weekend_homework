import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Card card;


    @Before
    public void before(){
        player = new Player("Emma");
        card = new Card(SuitType.HEARTS, RankType.TEN);
    }

    @Test
    public void canGetHandValue(){
        player.getHand(card);
        Integer num = 10;
        assertEquals(num, player.showHand(card));
    }



}
