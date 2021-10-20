// import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Array;
import java.util.*;
public class WordSearch {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
//        System.out.println("Please enter the filename with extension: ");
//        String fileName = in.nextLine();
        String fileName = "wordSearch.csv";
        Scanner fileScanner = new Scanner(new File(fileName));
        int rows = 0;
        int columns = 0;
        fileScanner.useDelimiter(",");
        System.out.println("check");
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
        System.out.println(columns);
        System.out.println(rows);

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
                    System.out.println(grid[i][j].length());
                    System.out.print(grid[i][j]);
                }
            }

        System.out.println("Something");
        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(i+" "+j);
                System.out.print(grid[i][j]);
            }
            System.out.print(" ");
        }

        System.out.println("Please enter a word to search");
//        String userInput = in.nextLine();
//        userInput = userInput.trim().toUpperCase();
        String userInput = "PAUL";


        //Horizontal forward
        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(i+" "+j);
                System.out.print(grid[i][j]);
            }
            System.out.print(" ");
        }
    }
}