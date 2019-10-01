import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.IOException;
//

/**
 *
 * @author Bhart 2019
 */
public class Sort
{
    // todo: make chat at [0] toUpper and letter after space toUpper so Jimi Hendrix
    public static void main(String[] args) throws FileNotFoundException
    {
        //instantiation
        String docTitle = "";
        Scanner in = new Scanner(System.in);
        boolean end = true;
        List<String> sortedList = new ArrayList<String>();
        System.out.println("Enter [/print] to display sorted items\nEnter [/end] to stop\nEnter [/save] to save data\nEnter [/remove entry_name] to remove element\nEnter [/help] to see these again");
        do{
            System.out.print("Enter: ");
            String tempString = in.nextLine();
            if(tempString.equals(""))
            {
                System.out.println("Nothing Entered, Try again please");
                tempString = "/";
            }
            if(tempString.equals("/help"))
            {
                System.out.println("Enter /print to display sorted items\nEnter /end to stop");
            }
            if(tempString.equalsIgnoreCase("/end"))
            {
                System.exit(0);
            }

            if(tempString.equalsIgnoreCase("/print"))
            {
                System.out.println(sortedList);
            }
            if(tempString.equals("/save"))
            {
                try{
                    System.out.print("Enter the name of the doc: ");
                    docTitle = in.nextLine();

                    PrintWriter writer = new PrintWriter(docTitle + ".txt", "UTF-8");

                    for(int i = 0; i < sortedList.size(); i++)
                    {
                        writer.println(sortedList.get(i));
                    }



                    writer.close();
                    //save the current sorted list as a notepad doc have it save vertical
                }
                catch(IOException ex)
                {
                    System.out.println (ex.toString());
                }
            }
            if(tempString.charAt(0) != '/')
            {
                sortedList.add(tempString);
                Collections.sort(sortedList);
            }

        }while(end);

    }
}
