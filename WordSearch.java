// import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Array;
import java.util.*;
public class WordSearch
{
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the filename with extension: ");
        String fileName = in.nextLine();
//      String fileName = "wordSearch.csv"; //Hard coded for Testing
        Scanner fileScanner = new Scanner(new File(fileName));   //TODO File not found errors and csv errors correction
        int rows = 0;
        int columns = 0;
        fileScanner.useDelimiter(",");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            rows++;
            columns=0;
            while (lineScanner.hasNext()) {
                String token = lineScanner.next();
                columns++;
            }
            lineScanner.close();
        }

        String[][] grid=new String[rows][columns];
        fileScanner.reset();

        Scanner charScan = new Scanner(new File(fileName));
        charScan.useDelimiter(",");
        String line;
        String[] chars;

        for (int i = 0; i < rows; i++)
        {
            line = charScan.nextLine();
            chars = line.split(",");
            for (int j = 0; j < columns; j++)
            {
                    grid[i][j] = chars[j].toUpperCase();
                }
            }

//        System.out.println("Below code prints the grid");
//        for(int i = 0; i < rows; i++)
//        {
//            for (int j = 0; j < columns; j++)
//            {
//
//                System.out.print(grid[i][j]);
//            }
//            System.out.println("");
//        }

        System.out.println("Please enter a word to search");
        String userInput = in.nextLine();
        userInput = userInput.trim().toUpperCase();
        int wordMatch =0;
        int characterIndex = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                // [1,1]
                if(grid[i][j].equals(userInput.substring(characterIndex,characterIndex+1)))
                {
                    int row = i;
                    int col = j;

                    while(grid[row][col].equals(userInput.substring(characterIndex,characterIndex+1))) {
                        System.out.println("match " + row + col);
                        col++;
                        characterIndex++;
                        if(characterIndex == userInput.length()) {

                            // Word has been match
                            wordMatch++;
                            break;
                        }

                        System.out.println("match " + row + col);
                        // in reverse horizontal direction
                        /*
                        col--;
                        characterIndex--;
                        if(characterIndex == userInput.length()) {
                            break;
                            // Word has been matched
                             wordMatch++;


                        }
                          */
                    }
                    characterIndex = 0;
                }
            }

        }
    }
}