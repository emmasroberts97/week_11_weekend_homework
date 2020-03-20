import org.junit.Before;
import org.junit.Test;

public class DealerTest {

    private Dealer dealer;

    @Before
    public void before(){
        dealer = new Dealer();
    }

    @Test
    public void canDealRandomCard(){
        System.out.println(dealer.dealCard());
    }
}
