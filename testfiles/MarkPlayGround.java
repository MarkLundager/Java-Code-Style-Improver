
import java.nio.file.Path;
import java.nio.file.Files;

public class MarkPlayGround {       
    public static void main(String[] args){
        int lineStart = Integer.parseInt(args[0]);
        int colStart = Integer.parseInt(args[1]);
        int lineEnd = Integer.parseInt(args[2]);
        int colEnd = Integer.parseInt(args[3]);
        StringBuilder sb = new StringBuilder();
        String[] content;
        String s = "";
        //linestart = 2;
        //colstart = 8
        //line end = 3;
        //colend = 14;


        Path filePath = Path.of("/mnt/c/users/Mark_/Documents/EDAN70/testfiles/marktemp.txt");
        //Path filePath = Path.of("C:\\Users\\Mark_\\Documents\\EDAN70\\testfiles\\marktemp.txt");
        try{
            content = Files.readString(filePath).split("\n");
            System.out.println(content[0]);
            System.out.println(content[1]);
            System.out.println(content[2]);
            s = content[0] + " " + content[1]  +  content[2];
            sb.append(content[0]);
            sb.append(content[1]);
            sb.append(content[2]);
            // for(int i = lineStart-1; i<=lineEnd-1; i++){
            //     if(i == lineEnd-1){
            //         sb.append(content[i]);
            //         System.out.println("lastline");
            //         System.out.println(sb.toString());
            //     }
            //     else{
            //         sb.append(content[i]);
            //         System.out.println("FirstLine");
            //         System.out.println(sb.toString() );
            //     }
            System.out.println(s);
            System.out.println(sb.toString());
            }
        catch(Exception e){
            e.printStackTrace();
        }

        

    }
}

