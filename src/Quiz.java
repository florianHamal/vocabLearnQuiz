import java.util.List;
import java.util.Scanner;

public class Quiz {
    public static void runQuiz(){
        DummyVocabDatabase database = DummyVocabDatabase.gerInstance();
        Scanner scanner = new Scanner(System.in);


        for (VocabCard vocabCard:database.getLvl(0)){
            System.out.println("---------------------------");
            System.out.println(vocabCard.getLanguageOne());

            String input = scanner.nextLine();
            System.out.println(vocabCard.getLanguageTwo());
            if (input == "ESC"){//wenn ESC:
                return;

            } else if (input==vocabCard.getLanguageTwo()) {//wenn richtig:
                vocabCard.setLvl(vocabCard.getLvl()+1);

            }else{ //wenn falsch:
                System.out.println("Was the answer right? y/other");

                if (scanner.nextLine().matches("y")){//frage ob doch richtig
                    vocabCard.setLvl(vocabCard.getLvl()+1);
                }
            }


        }
        return;
    }

}
