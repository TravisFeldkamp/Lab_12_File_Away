import javax.swing.JFileChooser;// Import
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();//declare new JFileChooser
        Scanner inFile ;//create new scanner
        String line;//declare variable
        Path target = new File(System.getProperty("user.dir")).toPath();//set current directory as working directory
        target = target.resolve("src");

        chooser.setCurrentDirectory(target.toFile());

        int numChars = 0;//create variables
        int numLines = 0 ;
        int numWords = 0 ;
        String fileName = "";


        try//open JFileChooser and let user select which file
        {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();//if file is selected get the path

            inFile = new Scanner(target) ;//create scanner for file

            while (inFile.hasNextLine()) {//read the file and read it line by line
                line = inFile.nextLine();
                numLines++;//add a line for each found
                numChars += line.length();// add a character for length of every line
                System.out.println(line);
                String[] words = line.split(" ");//read words that are split by space
                numWords += words.length;
            }

            inFile.close();//close scanner
        }
            else//if file not selected run this block
            {
                System.out.println("Sorry you must select a file!");
                System.exit(0);
            }
        }

            catch (FileNotFoundException e)//if file can't be found run this
            {
                System.out.println("File not found error");
                e.printStackTrace();

            }
        catch (IOException e){//run this if Io exception error occurs
            e.printStackTrace();
        }
        System.out.println("File name : " +target.getFileName());//print file name
        System.out.println("Number of Lines: " + numLines);//print lines in file
        System.out.println("Number of words: " + numWords);//print words in file
        System.out.println("Number of character: " + numChars);//print number of characters






    }
}