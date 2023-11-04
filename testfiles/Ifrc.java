public class Ifrc {       
    int x = 4;

    public static void main(String[] args) {

        System.out.println("appa" == "apa");
    }

    public boolean ifrc(int y){
        if(x>y){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean ifrcReversed(int y){
        if(x>y){
            return false;
        }
        else{
            return true;
        }
    }
}

