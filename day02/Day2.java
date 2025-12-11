package day02;

import java.io.File;
import java.io.FileInputStream;

public class Day2 {
    public static void main(String[] args) {
       parse(readInput(new File("day02/input.txt")));
      
    }
    public  static  String readInput(File input){
        String s = "";
        try (FileInputStream fis = new FileInputStream(input)) {
            
            int b;
            while((b = fis.read()) != -1){
                s += (char)b;
            }
        

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static  void parse(String s){ 
        String[] s1  = s.split(",");
        long sum = 0;
        String[] interval = new String[2];
        for(String str : s1){
           interval =  str.split("-");
            sum += invalidsSum(Long.parseLong(interval[0]), Long.parseLong(interval[1]));
        }
        System.out.println(sum);
    }


    public static  long invalidsSum(long min, long max) {
         long sum = 0;
            for (long i = min; i <= max; i++) {
               
                if (isInvalid(i)) {
                    sum += i;
                }
            }

        return sum;
    }


    static boolean isInvalid(long i) {
      
       if (Long.toString(i).length() % 2 != 0) {
            return false;
        }
        else {
            String s = Long.toString(i);
            int halfLength = s.length() / 2;
            String firstHalf = s.substring(0, halfLength);
            String secondHalf = s.substring(halfLength);
            
            return firstHalf.equals(secondHalf);
            
        } 
    }
   

}




