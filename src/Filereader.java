import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Filereader {

    private String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
    private BufferedReader reader;

    public Filereader(String path){
        this.path = path;
        readFile();
    }

    private void readFile(){
        try {
            FileReader fr = new FileReader(path);
            reader = new BufferedReader(fr);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLine() {
        try {
            return reader.readLine();

        } catch (IOException e) {
            System.out.println("Something went Wrong during File reading <ERROR>");
            e.printStackTrace();
            return null;
        }
    }
    public List<String> readAll(){
        List<String> retValue = new ArrayList<String>();
        String line;
        while ((line = readLine()) != null){
            retValue.add(line);
        }
        return retValue;
    }

    public String getPath() {
        return path;
    }
}
