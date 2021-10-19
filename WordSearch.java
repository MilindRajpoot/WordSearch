// import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;
public class WordSearch
{
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the filename with extension: ");
        String fileName =  in.nextLine();
        Scanner fileScanner;
        try
        {
            fileScanner = new Scanner(new File(fileName));
            readCSV(fileName,fileScanner);

            fileScanner.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static void readCSV(String fileName, Scanner fileScanner)
    {
        fileScanner.useDelimiter(",");
        while(fileScanner.hasNext())
        {
            System.out.println(fileScanner.next());
        }
    }
}