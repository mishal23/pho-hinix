// Java Program to illustrate reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;
public class inp
{
  public static void main(String[] args) throws Exception
  {
    // pass the path to the file as a parameter
    File file =
      new File("input.txt");
    Scanner sc = new Scanner(file);
 
    while (sc.hasNextLine())
      System.out.println(Integer.parse(sc.nextLine()));
  }
}
String str = myString.split(" ")[0];
str = str.replace("\\","");
String[] arr = str.split("u");
String text = "";
for(int i = 1; i < arr.length; i++){
    int hexVal = Integer.parseInt(arr[i], 16);
    text += (char)hexVal;
}