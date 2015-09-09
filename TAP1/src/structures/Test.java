package structures;

import java.util.*;

public class Test
{
   
  
   
   public static void main( String args[] ) 
   {
   		Collection<String> c;
    	
    	c = new ArrayList<String>();
    	test(c);
    	c = new LinkedList<String>();
    	test(c);
    	c = new HashSet<String>();
    	test(c);
     	c = new TreeSet<String>();
    	test(c);
    	
   }

 public static void test(Collection<String> c)
   {
   	 
     String strings[] = {"uno", "dos" , "tres", "cuatro", "tres"};
     
     
     for(String num:strings)
         c.add(num);                       
     
     for(String num:c)
           System.out.println(num);
     
     System.out.println( "-------------------------");

   	
   }
} 