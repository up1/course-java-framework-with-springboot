import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RandomNumberServiceTest {

    @Test
    public void random2() {
        Random1 random = new Random1();
        RandomNumberService service
                = new RandomNumberService(random);
        service.random();
        assertTrue(random.isCalled);
    }
}

class Random1 implements MyRandom {
    public boolean isCalled;

    public int nextInt(int bound) {
        isCalled = true;
        return 1;
    }
}