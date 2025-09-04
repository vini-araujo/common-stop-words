//Vinicius Araujo
//Assignment 2
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CommonStopWords {
    ArrayList<String> words = new ArrayList();

    public CommonStopWords() throws FileNotFoundException {  //constructor to read file
        File file = new File("src/common_stop_words.txt");
        Scanner scan = new Scanner(file);

        String fileContent = "";
        while (scan.hasNext()) {
            String word = scan.next();
            word = word.replace("'","");
            word = word.replace("-","");
            words.add(word);
        }

    }

    public ArrayList<String> printArray() {
        ArrayList<String> text = new ArrayList<>();
        text = words;
        return text;
    }

    public int wordCount() {
        int wordCount = words.size();
        return wordCount;
    }

    public String getElement(int index) {
        return words.get(index);
    }
}
