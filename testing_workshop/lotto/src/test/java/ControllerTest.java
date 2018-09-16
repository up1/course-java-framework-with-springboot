import com.lotto.lotto.category.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

@Category(UnitTest.class)
public class ControllerTest {

    @Test
    public void getById() {
        Repository repository = new StubRepository();
        Controller controller = new Controller();
        controller.setRepository(repository);
        controller.getById(1);
    }
}

class StubRepository implements   Repository {
    @Override
    public String getData(int id) {
        return "XXX";
    }
}

class StubRepository2 implements   Repository {
    @Override
    public String getData(int id) {
        return "XXX";
    }
}