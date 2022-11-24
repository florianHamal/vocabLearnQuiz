import javax.sound.midi.Soundbank;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class FIleManager {
    static String path = System.getProperty("user.dir")+"\\src"
    static String[] readFiles = {"vocab.csv"};
    static String[] writeFiles = {"vocab.csv"};

    public static void runnAll(){
        for (int i = 0;i<readFiles.length;i++){
            List<String> input = new Filereader(path+ File.separator+readFiles[i]).readAll();
            List<String> output = mainForEveryFile(input);
            System.gc(); // call gc cuz of using the same file in short time
            new Filewriter(path+ File.separator+writeFiles[i]).writeListContent(output);
        }
    }
    static public List<String> mainForEveryFile(List<String> list){
        DummyVocabDatabase database = DummyVocabDatabase.gerInstance();
        database.addVocabsFromList(list);
        Quiz.runQuiz();
        return database.toCsvList();
    }
}
