import java.util.*;  
public class list{  
public static void main(String args[]){  
ArrayList<String> al=new ArrayList<String>();  
al.add("Amit");  
al.add("Vijay");  
al.add("Kumar");  
al.add(1,"Sachin");  
System.out.println("Element at 2nd position: "+al.get(2));  
for(String s:al){  
 System.out.println(s);  
}  
}  
}  