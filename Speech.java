//Vinicius Araujo
//Assignment 2
import java.util.ArrayList;
import java.io.File;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Speech {
    static ArrayList<String> content = new ArrayList<>();   //ArrayList to store words from the file

    public Speech() throws FileNotFoundException {  //constructor to read file
        File file = new File("src/black_lives_matter_espy_speech.txt");
        Scanner scan = new Scanner(file);

        String fileContent = "";
        while (scan.hasNext()) {    //reading file
            String word = scan.next();
            //Removing punctuation marks
            word = word.replace(",", "");
            word = word.replace("\"", "");
            word = word.replace("“", "");
            word = word.replace("!", "");
            word = word.replace("?", "");
            word = word.replace("”", "");
            word = word.replace(".", "");
            word = word.replace(":", "");
            word = word.replace("'", "");
            word = word.replace("-", "");
            content.add(word);      //adding content of the file to the ArrayList
        }

    }

    public ArrayList<String> changeToLowerCase() {      //change ArrayList to all lower case
        for (int i = 0; i <= content.size() - 1; i++) {
            content.set(i, content.get(i).toLowerCase());
        }
        return content;
    }

    public ArrayList<String> printArray() {     //printArrayList
        ArrayList<String> text = new ArrayList<>();
        text = content;
        return text;
    }

    public int getWordCount() {     //get how many words the array list has
        int wordCount = content.size();
        return wordCount;
    }

    public int uniqueWordCount() {      //counts how many unique words it has
        ArrayList<String> uniqueWords = new ArrayList<>();

        for (int i = 0; i <= content.size() - 1; i++) {
            boolean equal = false;
            for (String word : uniqueWords) {
                if (word.equals(content.get(i))) {
                    equal = true;
                    break;
                }
            }
            if (!equal) {
                uniqueWords.add(content.get(i));
            }
        }

        return uniqueWords.size();
    }

    public int getSize() {      //gets number of indexes of the arraylist
        return content.size();
    }

    public String getElement(int index) {       //gets the element at certain index
        return content.get(index);
    }

    public void remove(int index) {     //removes certain index
        content.remove(index);
    }

    public ArrayList<String> countFrequency() {     //Counts how many times the word appeared
        ArrayList<String> uniqueWords = new ArrayList<>();      //ArrayList with unique words
        ArrayList<String> frequency = new ArrayList<>();        //ArrayList with each unique word next to each other in alphabetical order
        ArrayList<Integer> numberFrequency = new ArrayList<>();     //ArrayList with the number of times the word appears in alphabetical order
        ArrayList<String> decreasingFrequency = new ArrayList<>();  //ArrayList with the 50 most frequent words in decreasing order.
        for (int i = 0; i <= content.size() - 1; i++) {
            boolean equal = false;
            for (String word : uniqueWords) {
                if (word.equals(content.get(i))) {
                    equal = true;
                    break;
                }
            }
            if (!equal) {
                uniqueWords.add(content.get(i));
            }
        }
        int count = 1;
        for (int i = 1; i <= content.size() - 1; i++) {
            if (content.get(i).equals(content.get(i-1))) {
                count++;
            } else {
                frequency.add(content.get(i));
                numberFrequency.add(count);
                //System.out.println(content.get(i - 1) + ": " + count);
                count = 1;
            }
        }
        for (int j = 8; j > 0; j--) {
            for (int i = 0; i <= frequency.size() - 1; i++) {
                if (numberFrequency.get(i) == j ) {
                    decreasingFrequency.add(frequency.get(i));
                }
            }
        }
        //System.out.println(frequency);
        //System.out.println(numberFrequency);
        //Collections.sort(numberFrequency);    //sort number frequency from 1 to 8.
        //System.out.println(decreasingFrequency);    //
        return frequency;
    }

    //Method to get element at the decreasingFrequency array list at certain index.
    public String getDecreasingFrequency(int index) {
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<String> frequency = new ArrayList<>();
        ArrayList<Integer> numberFrequency = new ArrayList<>();
        ArrayList<String> decreasingFrequency = new ArrayList<>();
        for (int i = 0; i <= content.size() - 1; i++) {
            boolean equal = false;
            for (String word : uniqueWords) {
                if (word.equals(content.get(i))) {
                    equal = true;
                    break;
                }
            }
            if (!equal) {
                uniqueWords.add(content.get(i));
            }
        }
        int count = 1;
        for (int i = 1; i <= content.size() - 1; i++) {
            if (content.get(i).equals(content.get(i-1))) {
                count++;
            } else {
                frequency.add(content.get(i));
                numberFrequency.add(count);
                //System.out.println(content.get(i - 1) + ": " + count);
                count = 1;
            }
        }
        for (int j = 8; j > 0; j--) {
            for (int i = 0; i <= frequency.size() - 1; i++) {
                if (numberFrequency.get(i) == j ) {
                    decreasingFrequency.add(frequency.get(i));
                }
            }
        }
        String elementIndex = decreasingFrequency.get(index);
        return elementIndex;
    }

        public void sort() {    //sorts the arraylist in order
            Collections.sort(content);
        }





}