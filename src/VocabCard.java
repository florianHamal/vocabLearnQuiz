public class VocabCard {
    private String languageOne,languageTwo;
    int lvl;

    public VocabCard(String languageOne, String languageTwo, int lvl) {
        this.languageOne = languageOne;
        this.languageTwo = languageTwo;
        this.lvl = lvl;
    }

    public String getLanguageOne() {
        return languageOne;
    }

    public void setLanguageOne(String languageOne) {
        this.languageOne = languageOne;
    }

    public String getLanguageTwo() {
        return languageTwo;
    }

    public void setLanguageTwo(String languageTwo) {
        this.languageTwo = languageTwo;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
