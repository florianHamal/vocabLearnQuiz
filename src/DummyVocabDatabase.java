import java.util.ArrayList;
import java.util.List;

public class DummyVocabDatabase {
    private static DummyVocabDatabase instance;
    private List<VocabCard> vocabs= new ArrayList<>();

    public void addVocabFromString(String string){
        String[] args = string.split(";");
        vocabs.add(new VocabCard(args[0],args[1],Integer.parseInt(args[2])));
    }
    public void addVocabsFromList(List<String> list){
        for (String string:list){
            addVocabFromString(string);
        }
    }
    public static DummyVocabDatabase gerInstance(){
        if (instance==null){
            instance = new DummyVocabDatabase();
        }
        return instance;
    }

    public static DummyVocabDatabase getInstance() {
        return instance;
    }

    public static void setInstance(DummyVocabDatabase instance) {
        DummyVocabDatabase.instance = instance;
    }

    public List<VocabCard> getVocabs() {
        return vocabs;
    }

    public void setVocabs(List<VocabCard> vocabs) {
        this.vocabs = vocabs;
    }
    public List<String> toCsvList(){
        List<String> list= new ArrayList<>();
        for (VocabCard vocabCard:vocabs){
            list.add(vocabCard.getLanguageOne()+";"+vocabCard.getLanguageTwo()+";"+vocabCard.getLvl());
        }
        return list;
    }
    public List<VocabCard> getLvl(int lvl){
        List<VocabCard> list = vocabs.stream().filter(c -> c.getLvl()==lvl).toList();
        return list;
    }
}
