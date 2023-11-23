public class IfrcTest {       
    int x = 4;

    public static void main(String[] args) {

        ifrc(1);
        ifrcReversed(2);
    }

    public boolean ifrc(int y){
        if(y>3){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean ifrcReversed(int y){
        boolean mark = true;
        if(mark){
            return false;
        }
        else{
            return true;
        }
    }
}

