import java.io.File;
import java.io.Serializable;
//import java.io.FileInputStream;
//import java.io.StringReader;
import java.io.FileReader;
//import java.io.InputStream;
import java.io.BufferedReader;

class Day1 implements Serializable {

    static int pointer = 50;
    static int count0 = 0;
    public static void main(String[] args) {

        try (FileReader fis = new FileReader(new File("day01/input.txt"))) {
            BufferedReader br = new BufferedReader(fis);
            br.lines().forEach(
                (line) -> parse(line)
            );
           


        } catch (Exception e) {
            System.err.println("Not found");
        }
        System.out.println(count0);
        
   
    }
 

     public static void parse(String s){
         String digit =""; 
            for(int i =  1; i < s.length() ;  i++){

                digit += s.charAt(i);
            }      

            int d = Integer.parseInt(digit);
        if(s.charAt(0) == 'R'){

            rotation(true, d);

        }
        else if(s.charAt(0) == 'L'){

            rotation(false, d);

        }


     }

     public static void rotation(boolean direction, int digit){
        
        if(direction){
            pointer = (pointer + digit) % 100;


        }
         else{
            pointer -=  digit;
            
            if(pointer < 0){
                pointer = (100 + pointer)%100;
            }
        }
        if(pointer == 0){
            count0++;
        }
     }


}