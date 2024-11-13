
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muham
 */
public class Stuff {
    private static void timetable(int x){
        for(int i=1;i<=x;i++){
            for(int j=1;j<13;j++){
                System.out.printf("%d   ",i*j);
            }
            System.out.println();
        }
    }
         private static void timetablefile(int x){ // the file printer is not printing properly
             File file= new File("ttprint.txt");
        try {
            PrintWriter printer= new PrintWriter(file);
            //System.out.println("Fie is working");
             for(int i=1;i<=x;i++){
            for(int j=1;j<13;j++){
                 printer.printf("%d   ",i*j);//file
                System.out.printf("%d   ",i*j);//comand line
               
            }
            System.out.println();//command line
        printer.println();//file
    }

        } catch (FileNotFoundException ex) {
          System.out.println("FILE NOT FOUND");
        }
        
       
         }
         public static void visualclock(){// use arrays to make a grid for a clock
             int[][] clock= new int[13][13];
             // automatically put numbers in place
             clock[6][0]=12;
             clock[8][2]=1;
             clock[10][4]=2;
             clock[12][6]=3;
             clock[10][8]=4;
             clock[8][10]=5;
             clock[6][12]=6;
             clock[4][10]=7;
             clock[2][8]=8;
             clock[0][6]=9;
             clock[2][4]=10;
             clock[4][2]=11;
             
             for(int i=0;i<13;i++){
                 System.out.println();
                 for(int j=0;j<13;j++){
                     System.out.print(clock[i][j]);
                 }
             }
             
             
         }
    public static void main(String[]args){
        //timetablefile(12);
        visualclock();
    }
}
