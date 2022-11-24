import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Filewriter {

    private String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
    private File file;

    public Filewriter(String path){
        this.path= path;
        createFile();
    }


    private void createFile(){
        file = new File(path);
        try {
            if(!file.createNewFile()){
                file.delete();
                createFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLine(String line, boolean newLine){
        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);

            if(newLine) {
                bw.write(System.lineSeparator());
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeListContent(List<String> list){
        for (String line:list){
            writeLine(line,true);
        }
    }
}
