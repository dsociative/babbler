import junit.framework.TestCase;


public class BabblerTest extends TestCase {
    public Babbler babbler;

    public void setUp(){
        babbler = new Babbler("geektech.ru", 8885);
    }
}
