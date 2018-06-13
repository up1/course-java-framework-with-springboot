import java.util.Random;

public class RandomNumberService {

    MyRandom random;

    public RandomNumberService(MyRandom random) {
        this.random = random;
    }

    public int random() {
        return random.nextInt(10);
    }

}
