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
        String s = Long.toString(i);
        String subString = "";
        //outer loop for substring length
        //innerloop for substring comparison
        for(int substringLength = 1; substringLength <= s.length()/2; substringLength++){
            if(s.length() % substringLength != 0){
                continue;
            }
            subString = s.substring(0, substringLength);
            for (int indexPointer = 0; indexPointer <= s.length() - substringLength; indexPointer += substringLength) {
                if (subString.equals(s.substring(indexPointer, indexPointer + substringLength)) ) {
                    if (indexPointer == s.length()- substringLength ) { 
                       return true;
                    }
                } else {
                    indexPointer = s.length();
                }
                
            }

                
            

        }
        return false;


    }
   

}




