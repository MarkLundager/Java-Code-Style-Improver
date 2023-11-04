public class Mark {       
    int x = 4;

    public static void main(String[] args) {

        System.out.println("appa" == "apa");
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

