// Java Program to illustrate reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;
public class reading
{
  public static void main(String[] args) throws Exception
  {
    // pass the path to the file as a parameter
    File file =
      new File("input.txt");
    Scanner sc = new Scanner(file);
 
    while (sc.hasNextLine())
    {  
    	System.out.println(sc.nextLine());
    }
  }
}
