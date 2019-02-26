package zackKhalidov_06;

/*
   NumberGenerator - generate a file of random numbers, one per line
   
   Author: Dr. Salim Lakhani
   Modified by: Mr. David Kramer
*/

import java.io.*;
import java.util.Random;

public class NumberGenerator {
   public static void main (String[] args) throws IOException {
	   
      final int NUM_NUMBERS = 100;     // # of random #s to generate
      final int MAX_NUMBER  = 10000;   // Maximum number to generate, + 1
      Random randomNumbers = new Random();
      File file = new File ("hw6input.txt");
      PrintWriter pw = new PrintWriter (file);
      
      for (int i = 0; i < NUM_NUMBERS; i++) {
         pw.println (randomNumbers.nextInt(MAX_NUMBER));
      }
      
      pw.close();
      
   }
}