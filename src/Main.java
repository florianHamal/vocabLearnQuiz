import java.util.List;

public class Main {
    public static void main(String[] args) {
        FIleManager.runnAll(new FileRunnerInterface() {
            @Override
            public List<String> runForEveryFile(List<String> list) {
                DummyVocabDatabase database = DummyVocabDatabase.gerInstance();
                database.addVocabsFromList(list);
                Quiz.runQuiz();
                return database.toCsvList();
            }
        });
    }
}