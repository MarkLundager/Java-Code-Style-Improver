

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkPlayGround {       
    public static void main(String[] args){
        int lineStart = Integer.parseInt(args[0]);
        int colStart = Integer.parseInt(args[1]);
        int lineEnd = Integer.parseInt(args[2]);
        int colEnd = Integer.parseInt(args[3]);
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        String[] content;
        String s = "";
        //linestart = 2;
        //colstart = 8
        //line end = 3;
        //colend = 14;

        try{
            File file = new File("/mnt/c/users/Mark_/Documents/EDAN70/testfiles/marktemp.txt");
            Scanner scnr = new Scanner(file);
            for(int i = 0; i<lineStart-1; i++){
                scnr.nextLine();
            }
            for(int i = 0; i < lineEnd+1-lineStart; i++){
                
                if(i < lineEnd-lineStart){
                    sb.append(scnr.nextLine());
                    sb.append("\n");
                }
                else{
                    sb.append(scnr.nextLine().substring(0, colEnd));
                }
            }
            String temp = sb.toString();
            Pattern test = Pattern.compile("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/|(//.*\n)");
            Matcher matcher = test.matcher(temp);
            while(matcher.find()){
                System.out.println("Found: " + matcher.group());
                result.append(matcher.group());
            }
                System.out.println("yeap " +result.toString());
                if(result.toString().equals("")){
                    System.out.println("SADASDSASASADSA");

                }
            }
        catch(Exception e){
            e.printStackTrace();
        }

        /*
        */

    }
}

