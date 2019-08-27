
/**
 * Class Entrant - Simulates an entrant in Walton Classic Car Race.
 * 
 * @author M250 Course Team 
 * @version Version 1.0
 */
public class Entrant implements Comparable<Entrant>
{

   /* instance variables */

   private int number;       // entrant's number
   private String name;      // entrant's name
   private String category;  // "E1", "E2" or "E3"
   private double time;      // entrant's marathon time in seconds

   // class variables
   private static int nextNumber = 1;
   
   
   /**
    * Constructor for objects of class Entrant.
    */
   public Entrant()
   {
      super();
      name = "";
      category = "";
      time = 0.0;
      number = nextNumber;
      nextNumber++;
   }
   
   /**
    * compares the times of the entrants
    * returns 0 if equal, negative if the first value is less than the second
    * and a positive if the first value is greater than the second
    */
   @Override
   public int compareTo(Entrant otherEntrant)
   {
      return (Double.compare(this.getTime(), otherEntrant.getTime()));
   }
   
   //Only those getter and setter methods that you will need have been included

   /**
    * getter for number
    */
   public int getNumber()
   {
      return number;
   }

   /**
    * getter for name
    */
   public String getName()
   {
      return name;
   }

   /**
    * setter for name
    */
   public void setName(String aName)
   {
      name = aName;
   }

   /**
    * getter for category
    */
   public String getCategory()
   {
      return category;
   }

   /**
    * setter for category
    */
   public void setCategory(String carType)
   {
      category = carType;
   }

   /**
    * getter for time
    */
   public double getTime()
   {
      return time;
   }  

   /**
    * setter for time
    */
   public void setTime(double aTime)
   {
      time = aTime;
   }


}
