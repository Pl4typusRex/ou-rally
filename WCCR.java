import java.util.*;
import java.io.*;
import ou.*;

/**
 * Reads the entrants file
 * 
 * @author Sophie Wallace
 * @version 1.0
 */
public class WCCR
{
   // instance variables
   private List<Entrant> entrants;
   private Map<String,Double> e1Results;
   private Map<String,Double> e2Results;
   private Map<String,Double> e3Results;
   
   /**
    * Constructor for objects of class WCCR
    */
   public WCCR()
   {
      entrants = new ArrayList<>();
      e1Results = new TreeMap<>();
      e2Results = new TreeMap<>();
      e3Results = new TreeMap<>();
   }

   /**
    * sorts entrants into one of three categories based on the category code
    */
   public void categorise()
   {
      for (Entrant e : entrants)
      {
         if (e.getCategory().equals("E1"))
         {
            e1Results.put(e.getName(), e.getTime());
         }
         else if (e.getCategory().equals("E2"))
         {
            e2Results.put(e.getName(), e.getTime());
         }
         else if (e.getCategory().equals("E3"))
         {
            e3Results.put(e.getName(), e.getTime());
         }
      }
   }
   
   /**
    * sorts the entrants based on time
    */
   public void sortEntrantList()
   {
      Collections.sort(entrants);
   }
   
   /**
    * generate a random double for each entrant
    */
   public void runRally()
   {
      for(Entrant e : entrants)
      {
         e.setTime(generateTime());
      }
   }
   
   /**
    * returns a random double value between 30.00 and 60.00
    */
   private double generateTime()
   {
      Random random = new Random();
      double randomDouble = 30.00 + (60.00 - 30.00) * random.nextDouble();
      return randomDouble;
   }
   
   /**
    * Prompts the user for the entrants file
    * Creates new entrant objects using the name and categories in the file
    * The adds those entrant objects to the entrants list
    */
   public void readInEntrants()
   {
      String readFilePath = OUFileChooser.getFilename();
      File file = new File(readFilePath);
      BufferedReader buffRead = null;
      
      try
      {
         buffRead = new BufferedReader(new FileReader(file)); 
         String line = buffRead.readLine();
         Scanner lineScan;
         
         while(line != null)
         {
            lineScan = new Scanner(line);
            lineScan.useDelimiter(",");
            
            Entrant e = new Entrant();
            e.setName(lineScan.next());
            e.setCategory(lineScan.next());
      
            entrants.add((e.getNumber()-1), e);
            
            line = buffRead.readLine();
         }
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e);
      }
      finally
      {
         try
         {
            buffRead.close();
         }
         catch (Exception e)
         {
            System.out.println("Error: " + e);
         }
      }
   }
   
}
