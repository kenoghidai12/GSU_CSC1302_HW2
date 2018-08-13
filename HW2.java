// HW 2
import java.util.*;

public class HW2 {
   private static Scanner console = new Scanner (System.in);
   
   public static void main (String[]arfs) {
      
      giveIntro();
      playTime();      
   }
   
   public static void giveIntro () {
      System.out.println ("Human, I will create a hyena or a critter for you.");
   }
   
   public static void playTime () {
      String choice = "";
      System.out.println ("Do you want to create a critter [c] or a hyena [h]?");
      Critter h = null;
      do {
         choice = console.next();
         if (choice.equals ("c")) {
            h = new Critter ();
         }else if (choice.equals ("h")){
            h = new Hyena();
         }else{
            System.out.println ("Wrong choice, please choose again.");
            choice = console.next();
         }
      }while (h == null);
      System.out.println ("Let's make them find food");
      h.findFood();      
   }
}

class Critter {
   private String pattern;
   
   //constructors
   public Critter () {
      pattern = "Human, the Critter has not started to find it's food, yet.";
   }
   
   // getter methods
   public String getPattern () {
      return pattern;
   }
   
   //other methods
   public void findFood () {
      pattern = "";
      pattern = createPattern();
   }
   
   //create pattern for method findFood
   public String createPattern () {
      System.out.println ("Critter will have random traveling.\n[Enter] to keep finding food, [e] to find and eat food, [s] to stop.");
      Scanner console = new Scanner (System.in);
      String choose = "";
      String pattern = "";
      
      do {
         if (!choose.equals ("e")) {
            double x = Math.random();
            if (x <= 0.25) {
               System.out.print("N,");
               pattern += "N,";
            }
            else if (x <= 0.5) {
               System.out.print("E,");
               pattern += "E,";
            }
            else if (x <= 0.75) {
               System.out.print("S,");
               pattern += "S,";
            }
            else {
               System.out.print("W,");
               pattern += "W,";
            }
         
            choose = console.nextLine();
         }else{ //choose == "e"
            System.out.println ("(eat food),");
            pattern += "(eat food),";
            choose = console.nextLine();
         }
      }while (!choose.equals ("s"));
      System.out.print ("The pattern of our critter is:\n" + pattern);
      return pattern;
   }
}

class Hyena extends Critter {
   //constructors
   public Hyena () {
      super();
   }

   //getter methods: inherited
   

   //hyena has different travel path.
   public String createPattern () {
      System.out.println ("Hyena has rectangle travel path.\n[Enter] to keep finding food, [e] to find and eat food, [s] to stop.");
      String pattern = "";
      Scanner console = new Scanner (System.in);
      int count = 1;
      String choose = "";
      do {
         if (!choose.equals("e") && !choose.equals("s")) {
            System.out.print("N,");
            pattern += "N,";
            choose = console.nextLine();
         }
         for (int i = 0; i<count && !choose.equals("e") && !choose.equals("s"); i++) {
            System.out.print("E,");
            pattern += "E,";
            choose = console.nextLine();
         }
         if (!choose.equals("e") && !choose.equals("s")) {
            System.out.print("S,");
            pattern += "S,";
            choose = console.nextLine();
         }
         for (int i = 0; i<count && !choose.equals("e") && !choose.equals("s"); i++) {
            if (i == count-1) {
               System.out.print("W;");
               pattern += "W;\n";
            }else{
               System.out.print("W,");
               pattern += "W,";
            }
            choose = console.nextLine();
         }
         if (choose.equals("e")) {
            System.out.print ("(eats food),");
            pattern += "(eats food);\n";
            choose = console.nextLine();
         }
         count++;
      }while (!choose.equals("s"));
      System.out.print ("The pattern of our hyena is:\n" + pattern);
      return pattern;
   }
}