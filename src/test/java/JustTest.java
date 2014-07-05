import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JustTest {
    public Babbler babbler;

    @Before
    public void setUp(){
        this.babbler = new Babbler("Vasia");
    }

    @Test
    public void hello() {
        assertEquals(babbler.hello(), "hi my name is Vasia");
    }

}
