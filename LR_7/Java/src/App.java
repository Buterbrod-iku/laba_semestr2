import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        try(FileReader fin = new FileReader("test.txt"))
        {
            Scanner Reader = new Scanner(fin);
            ArrayList<String> check = new ArrayList<String>();
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                check.add(data);
            }

            for(int i = 0; i < check.size(); i += 2){
                String[] words = check.get(i).split(" ");
                String cash = words[0];
                words[0] = words[words.length-1];
                words[words.length-1] = cash;
                String resultWords = "";
                for (String word : words) {
                    resultWords += word + " ";
                }
                System.out.println(resultWords);
            }
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
}
