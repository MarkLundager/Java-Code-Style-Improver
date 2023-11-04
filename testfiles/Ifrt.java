public class Ifrt {       
    int x = 4;

    public static void main(String[] args) {

       ifrt(1);
       ifrtReversed(2);
    }
    public boolean ifrt(int y){
        if(x>y){
            return true;
        }
        return false;
    }

    public boolean ifrtReversed(int y){
        if(x>y){
            return false;
        }
        return true;
    }
}

