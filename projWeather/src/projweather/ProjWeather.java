/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projweather;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Scot Livingstone 
 */
 
public class ProjWeather {
 static int arrTemp [ ] = new int [100];
 static int arrWind [ ] = new int [100];
 static int size = 0;
    /**
     * @param args the command line arguments
     */
   /**
    * This is the main menu of the application which is run by numeric values
    */
    public static void Menu(){
    
    System.out.println("Main Menu");
    System.out.println ("************************************************************************");
    System.out.println("1:Find maximum temperature");
    System.out.println("2:Find minimum temperature");
    System.out.println("3:Find average temperature");
    System.out.println("4:Find number of occasions temperature has been above a certain value");
    System.out.println("5:Find number of occasions temperature has been below a certain value");
    System.out.println("6:Find maximum wind speed and Beaufort Scale");
    System.out.println("7:Find minimum wind speed and Beaufort Scale");
    System.out.println("8:Find average wind speed and Beaufort Scale");
    System.out.println("9:Find number of occasions wind speed has been above a certain Knots");
    System.out.println("10:Find number of occasions wind speed has been below a certain Knots");
    System.out.println("11:Help menu");
    System.out.println("0:Exit");
    System.out.println("******************************************************************************");
    
    Scanner myscan = new Scanner (System.in);
    int num;
    System.out.println("Enter choice:");
    //prevents non-numeric values from being entered
    while (!myscan.hasNextInt()) myscan.next();
    num = myscan.nextInt();
     if(num == 1) MaxTemp();
     if(num == 2) MinTemp();
     if(num == 3) AverageTemp();
     if(num == 4) GreaterthanTemp();
     if(num == 5) LessthanTemp();
     if(num == 6) MaxWind();
     if(num == 7) MinWind();
     if(num == 8) AverageSpeed();
     if(num == 9) GreaterthanWind();
     if(num == 10) LessthanWind();
     if(num == 11) Help();
     if(num == 0) System.exit(0);
}
    /**
     * This is to read in the temperature text file into the array
     */
    public static void arrTemp() {
        
        boolean notfinished = true;
        int count = 0; 
        
        File f = new File("temperatures.txt");
         try{
              Scanner myscan = new Scanner(f);
              while (notfinished)
              {
                  arrTemp[count] = myscan.nextInt();
                  if (arrTemp [count]== -999)
                  {
                      notfinished = false;
                      size= count - 1;
                  }
                  count = count + 1; 
              }
                
	     }
       	catch (FileNotFoundException e) {
              System.out.println("File input error");
         } 
         
          for (count = 0; count<= size; count++)
         {
             System.out.print(" " + arrTemp[count]);
         }
    }
    /**
     * This is to read in the wind speed array text file into the array
     */
    public static void arrWind() {
        boolean notfinished = true;
         
        int count = 0; 
        
        File f = new File("windspeeds.txt");
         try{
              Scanner myscan = new Scanner(f);
              while (notfinished)
              {
                  arrWind[count] = myscan.nextInt();
                  if (arrWind [count]== -999)
                  {
                      notfinished = false;
                      size= count - 1;
                  }
                  count = count + 1; 
              }
                
	     }
       	catch (FileNotFoundException e) {
              System.out.println("File input error");
              
         } 
         
         for (count = 0; count<= size; count++)
         {
             System.out.print(" "+ arrWind[count]);
         }
         
       
    }
    /**
     * This is to show the user the maximum temperature in the temperature array
     */
    public static void MaxTemp(){
     
    
    
    int max = arrTemp[0];
             
    for(int i = 0; i < arrTemp.length; i++){
          
        if(arrTemp[i]> max){
                max = arrTemp[i];
                
            }
                  
        }
     System.out.println("The maximum temperature is " + max);
    Menu2();
    
}
     /**
     * This is to show the user the minimum temperature in the temperature array
     */
    public static void MinTemp(){
    
  
          
   int min = arrTemp[0];
             
    for(int i = 0; i < arrTemp.length; i++){
          
        if(arrTemp[i]< min){
            
            min = arrTemp[i];
                
            }
                  
        }
    System.out.println("The minimum temperature is " + min);
    Menu2();
    
}
 /**
  * This is to show the user the average temperature in the temperature array
  */
public static void AverageTemp(){
    
  
          
   int total = 0;
             
   for(int tempVal : arrTemp){
          total+=tempVal;
        }
            
    int average = 0;
    
    average = total / arrTemp.length;
        
    System.out.println("The average temperature is " + average);
    Menu2();
       
}
/**
 * This is to show the user how many temperatures are warmer than the one they entered 
 */
public static void GreaterthanTemp(){
  
  
  
  Scanner myscan = new Scanner (System.in);
  int num;
  System.out.println("Please enter a temperature");
  while (!myscan.hasNextInt()) myscan.next();
  num = myscan.nextInt();
          
  int count = 0;
             
  for(int i = 0; i < arrTemp.length; i++){
          
        if(arrTemp[i] > num){
            count++;
            }           
        }
    System.out.println("The temperature has been warmer than " + num + " " + count);
    Menu2();
    
    
}
/**
 * This is to show the user how many temperatures are colder than the one they entered 
 */
public static void LessthanTemp(){

   
 
  
  Scanner myscan = new Scanner (System.in);
  int num;
  System.out.println("Please enter a temperature");
  while (!myscan.hasNextInt()) myscan.next();
  num = myscan.nextInt();
   
  int count = 0;
             
  for(int i = 0; i < arrTemp.length; i++){
          
        if(arrTemp[i] < num){
            count++;
            }           
        }
    System.out.println("The temperature has been colder than " + num + "" + count);
    Menu2();
    
}
/**
 * This shows the user the Beaufort scale
 * @param num
 * @return beufortScale
 */
  public static String BeaufortScale(int num){
    String beaufortScale = "";
    
        if(num <1 ) beaufortScale ="Calm";
        if((num >=1) &&(num<=3)) beaufortScale ="Light Air";
        if((num >=4)&&(num<=7)) beaufortScale ="Light Breeze";
        if((num >=8)&&(num<=12)) beaufortScale ="Gentle Breeze";
        if((num >=13)&&(num<=18)) beaufortScale ="Moderate Breeze";
        if((num >=19)&&(num<=24)) beaufortScale ="Fresh Breeze";
        if((num >=25)&&(num<=31)) beaufortScale ="Strong Breeze";
        if((num >=32)&&(num<=38)) beaufortScale ="Moderate Gale";
        if((num >=39)&&(num<=46)) beaufortScale ="Fresh Gale";
        if((num >=47)&&(num<=54)) beaufortScale ="Strong Gale";
        if((num >=55)&&(num<=63)) beaufortScale ="Whole Gale";
        if((num >=64)&&(num<=72)) beaufortScale ="Storm";
        if(num >=73) beaufortScale ="Hurricane Force";
    
    return beaufortScale;
}
  /**
   * This shows the user what scale there wind speed is
   * @param num
   * @return scale
   */
public static int Scale(int num){
    int scale = 0;
    
        if(num <1 ) scale=0;
        if((num >=1)&&(num<=3)) scale=1;
        if((num >=4)&&(num<=6)) scale=2;
        if((num >=7)&&(num<=10)) scale=3;
        if((num >=11)&&(num<=16)) scale=4;
        if((num >=17)&&(num<=21)) scale=5;
        if((num >=22)&&(num<=27)) scale=6;
        if((num >=28)&&(num<=33)) scale=7;
        if((num >=34)&&(num<=40)) scale=8;
        if((num >=41)&&(num<=47)) scale=9;
        if((num >=48)&&(num<=55)) scale=10;
        if((num >=56)&&(num<=63)) scale=11;
        if(num >=64) scale=12;
    
    return scale;
}
/**
 * This will show the user the maximum wind speed that is in the wind speed array
 */
  public static void MaxWind(){
     

    
    int max = arrWind[0];
             
        for(int i = 0; i < arrWind.length; i++){
          
            if(arrWind[i]> max){
                max = arrWind[i];
                
            }
                  
        }
         
    System.out.println("The maximum wind speed is " + max + "The Beaufort Wind Scale is " + (Scale(max)) + " which means it is a " + (BeaufortScale(max)) ) ;
    Menu2();
    
}
  /**
 * This will show the user the minimum wind speed that is in the wind speed array
 */
    public static void MinWind(){
     
    
    
    int min = arrWind[0];
             
        for(int i = 0; i < arrWind.length; i++){
          
            if(arrWind[i]< min){
                min = arrWind[i];
                
            }
                  
        }
         
    System.out.println("The minimum wind speed is " + min + "The Beaufort Wind Scale is " + (Scale(min)) + " which means it is a " + (BeaufortScale(min)) ) ;
    Menu2();
    
}
 /**
 * This will show the user the average wind speed that is in the wind speed array
 */
    public static void AverageSpeed(){
    
  
          
   int total = 0;
             
    for(int speedVal : arrWind){ 
          total+=speedVal; 
        }
            
    int average = 0;
    
    average = total / arrWind.length;
        
    System.out.println("The average wind speed is " + average + "The Beaufort Wind Scale is" + (Scale(average)) + " which means it is a " + (BeaufortScale(average)) ) ;
    
    Menu2();
       
}
    /**
     * This will show the user how many times the wind speed has been faster than the wind speed that they entered
     */
    public static void GreaterthanWind(){
    
  
  
  Scanner myscan = new Scanner (System.in);
  int num;
  System.out.println("Please enter a wind speed");
  while (!myscan.hasNextInt()) myscan.next();
  num = myscan.nextInt();
          
  int count = 0;
             
  for(int i = 0; i < arrWind.length; i++){
          
        if(arrWind[i] > num){
            count++;
            }           
        }
   System.out.println("The wind speed has been faster than " + num  +" " + count);
    
   Menu2();
    
    
}
    /**
     * This will show the user how many times the wind speed has been slower than the wind speed that they entered
     */
    public static void LessthanWind(){
    
  
  
  Scanner myscan = new Scanner (System.in);
  int num;
  System.out.println("Please enter a wind speed");
  while (!myscan.hasNextInt()) myscan.next();
  num = myscan.nextInt();
   
  int count = 0;
             
  for(int i = 0; i < arrWind.length; i++){
          
        if(arrWind[i] < num){
            count++;
            }           
        }
   System.out.println("The wind speed has been slower than " + num + " " + count);
    
   Menu2();
    
    
}
    /**
     * This is the menu that appears after the user selected an option in the main menu, this is also numeric based
     */
    public static void Menu2(){
    Scanner myscan = new Scanner (System.in);
    int num;
   
    System.out.println("To return press 1");
    System.out.println("To close the appliaction press 2");
    System.out.println("Enter choice:");
    while (!myscan.hasNextInt()) myscan.next();
    num = myscan.nextInt();
     if(num == 2) System.exit(0);
     if(num == 1) Menu();


}
    /**
     * This is the on screen help that tells the user how to use the programme
     */
    public static void Help(){
    
    
    System.out.println("Help");
    System.out.println("********************************************************************************************************");
    System.out.println("To work this application you need to enter numbers which correspond to the number in the menu thhat you wnat to select ");
    System.out.println("Pressing number 1 will show you the max temperature");
    System.out.println("Pressing number 2 will show you the minimum temperature");
    System.out.println("Pressing number 3 will show you the average temperature");
    System.out.println("Pressing number 4 will allow type in a number a using that number it will tell you how many temperatures are above that number ");
    System.out.println("Pressing number 5 will allow type in a number a using that number it will tell you how many temperatures are below that number ");
    System.out.println("Pressing number 6 will show you the max wind speed");
    System.out.println("Pressing number 7 will show you the minimum wind speed");
    System.out.println("Pressing number 8 will show you the average temperature");
    System.out.println("Pressing number 9 will allow type in a number a using that number it will tell you how many wind speeds are above that number");
    System.out.println("Pressing number 10 will allow type in a number a using that number it will tell you how many wind speeds are below that number");
    System.out.println("Pessing number 0 will close the application");
    System.out.println("********************************************************************************************************");   
    Menu2();
    
}
 /**
  * This is the main code of the programme
  * @param args 
  */   
    public static void main(String[] args) {
       
        System.out.println("The numbers in the Temperature array are   ");
        arrTemp();
        System.out.println("");
        System.out.println("The numbers in the Wind array are    ");
        arrWind();
        System.out.println("     ");
        Menu();
    }
    
}
