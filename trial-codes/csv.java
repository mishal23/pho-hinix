import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csv {

    public static void main(String[] args) {

        String csvFile = "hindi_words.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String> x = new ArrayList();
        List<String> listClone = new ArrayList<String>();        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                
                String[] hindiwords = line.split(cvsSplitBy);
                
                x.add(hindiwords[0]);
                System.out.println(hindiwords[0]);// + " " + hindiwords[1] + " " + hindiwords[2]);
                
            }
            for (String string : x) {
               if(string.matches("त")){
                   listClone.add(string);
               }
           }
        System.out.println("Matched: "+ listClone);
            System.out.println(x);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}