import java.util.*;
import java.io.*;

public class csv4 
{
    static boolean eng = false;
    public static void main(String[] args) throws Exception
    {
        String csvFile = "hindi_words.csv";                     //Hindi Dictionary
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashSet<String> dict = new HashSet<String>();                   // Store all the Hindi words in Dictionary
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) 
        {
                String[] hindiwords = line.split(cvsSplitBy);   //Split the words by ,
                for(int i=0;i<40;i++)
                {
                    dict.add(hindiwords[i]);
                }
        }
        File file = new File("input.txt");                      
        Scanner sc = new Scanner(file);
        File file2 = new File("output.txt");
         // create the file
        file.createNewFile();
        // create a FileWriter Object
        FileWriter writer = new FileWriter(file2);
         // Write the content to the file
        writer.write("Output");
        while (sc.hasNextLine())
        {
            String myString = sc.nextLine();
            String str[] = myString.split(" ");
            String str1 = str[0];
            String str2 = str[1];
            if (checkEng(str2)){
            eng=true;
        }
        if(!eng)
        {
            if (dict.contains(str1) && dict.contains(str2))
            {  
                writer.write("0\n");
                if(str[2].equals("0")){
                  System.out.println("match");
                }
                else{
                  System.out.println("mismatch");
                }
                continue;
            }
        }
        String Encoded_String1 = Encode_String(str1,1);
        String Encoded_String2 = Encode_String(str2,2);
        if(Encoded_String1.equals(Encoded_String2))
        {
            writer.write("1\n");
            if(str[2].equals("1"))
                System.out.println("match");
            else
                System.out.println("mismatch");
        }
        else
        {
            writer.write("0\n");
            if(str[2].equals("0"))
                System.out.println("match");
            else
                System.out.println("mismatch");
            eng=false;
        }
    }
    writer.flush();
    writer.close();
}
public static boolean checkEng(String str)
{
   if(str.charAt(0)<127)
        return true;
   else
        return false;
}

// English to Hindi
public static String Encoding_Eng(String hex)
{
    HashMap<String,String> encode=new HashMap<String,String>();
    encode.put("b", "k");
    encode.put("c", "d");
    encode.put("d", "i");
    encode.put("f", "j");
    encode.put("g", "e");
    encode.put("h", "s");
    encode.put("j", "g");
    encode.put("k", "d");
    encode.put("l", "p");
    encode.put("m", "m");
    encode.put("n", "l");
    encode.put("p", "j");
    encode.put("q", "d");
    encode.put("r", "o");
    encode.put("s", "r");
    encode.put("t", "h");
    encode.put("v", "q");
    encode.put("w", "q");
    encode.put("x", "g");
    encode.put("y", "n");
    encode.put("z", "g");
    boolean contains = encode.containsKey(hex);
    //System.out.println("English");
    if(contains)
    {
       return encode.get(hex);
    }
    else
        return "";
 }
public static String Encoding(String hex)
{
    //   List<String> ignore = Arrays.asList("0900", "0901", "0902", "0903", "");
    //   boolean contains_ignore = ignore.contains(hex);
    HashMap<String,String> encode=new HashMap<String,String>();

    //
    encode.put("0907", "a");
    encode.put("0908", "a");
    encode.put("090e", "a");
    encode.put("090f", "a");

    //
    encode.put("0909", "b");
    encode.put("090a", "b");
    encode.put("0913", "b");
    encode.put("0914", "b");


    encode.put("0905", "c");
    encode.put("0906", "c");

    encode.put("0915", "d");
    encode.put("0916", "d");

    encode.put("0917", "e");
    encode.put("0918", "e");

    encode.put("091a", "f");
    encode.put("091b", "f");

    encode.put("091c", "g");
    encode.put("091d", "g");

    encode.put("091f", "h");
    encode.put("0920", "h");
    encode.put("0924", "h");
    encode.put("0925", "h");

    encode.put("0921", "i");
    encode.put("0922", "i");
    encode.put("0926", "i");
    encode.put("0927", "i");

    encode.put("092a", "j");
    encode.put("092b", "j");

    encode.put("092c", "k");
    encode.put("092d", "k");

    encode.put("0919", "l");
    encode.put("091e", "l");
    encode.put("0923", "l");
    encode.put("0928", "l");

    encode.put("092e", "m");

    encode.put("092f", "n");

    encode.put("090b", "o");
    encode.put("0930", "o");

    encode.put("0932", "p");

    encode.put("0935", "q");

    encode.put("0936", "r");
    encode.put("0937", "r");
    encode.put("0938", "r");

    encode.put("0939", "s");

    //Matras
      if(!eng)
      {
          encode.put("093f", "A");
          encode.put("0940", "A");

          encode.put("0941", "B");  
          encode.put("0942", "B");

          encode.put("0947", "C");
          encode.put("0948", "C");

          encode.put("094b", "D");
          encode.put("094c", "D");
      }
      boolean contains = encode.containsKey(hex);
      if(contains)
      {
        return encode.get(hex);
      }
      else
        return "";
}

public static String Encode_String(String str,int a)
{
    String Encoded_Str = "";

    for(int i=0; i < str.length(); i++)
    {
        char c = str.charAt(i);
        String s = ""+c;

        if(a==1)
        {
            int x = Integer.valueOf(c);
            String hex = Integer.toHexString(x);
            hex="0"+hex;
            Encoded_Str += Encoding(hex);
        }
        else
        {
            if(eng)
            {
                Encoded_Str += Encoding_Eng(s);
            }
            else
            {
                int x = Integer.valueOf(c);
                String hex = Integer.toHexString(x);
                hex="0"+hex;
                Encoded_Str += Encoding(hex);
            }
        }

   }
   return Encoded_Str;
}
}
