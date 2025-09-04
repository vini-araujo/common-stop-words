//Vinicius Araujo
//Assignment 2
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Speech speech = new Speech();   //Creating a Speech object to read the file.
        System.out.println("black_lives_matter_espy_speech.txt: " + speech.getWordCount() + " total words");

        speech.changeToLowerCase(); //changing to lower case

        System.out.println("Number of unique words: " + speech.uniqueWordCount());  //print unique words
        System.out.println();

        CommonStopWords commonWords = new CommonStopWords();
        System.out.println("common_stop_words.txt: " + commonWords.wordCount() + " total words");

        //for loop to remove all the words from the Common Stop Words on the speech file.
        for (int i = 0; i < speech.getSize() - 1; i++) {
            for (int j = 0; j < commonWords.wordCount() - 1; j++) {
                if (speech.getElement(i).equals(commonWords.getElement(j))) {
                    speech.remove(i);
                }
            }
        }
        System.out.println("\n" + "black_lives_matter_espy_speech.txt modified After Removing Common Stop Words: " + speech.getWordCount() + " words");
        System.out.println("Number of unique words: " + speech.uniqueWordCount());
        System.out.println();
        speech.sort();
        //System.out.print(speech.printArray());
        speech.countFrequency();
        //System.out.println(speech.countFrequency());
        //System.out.println(speech.getDecreasingFrequency(2)); //testing to see if the method is working and getting the element at index given as parameter.

        try {      //writing a new file with the 50 most frequent words in decreasing order
            PrintWriter writer = new PrintWriter("src/A2_Word_Cloud.txt");
            for (int i = 0; i < 50; i++) {
                writer.println(speech.getDecreasingFrequency(i));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}