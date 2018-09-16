public class Demo {
}

interface Repository {
    public String getData(int id);
}

class Controller {
    Repository repository;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public String getById(int id) {
        String result = repository.getData(id);
        return result;
    }
}
