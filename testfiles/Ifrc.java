public class Ifrc {       
    int x = 4;

    public static void main(String[] args) {

        ifrc(1);
        ifrcReversed(2);
    }

    public boolean ifrc(int y){
        if(x/*crazy comment 1*/>y/*Comment 2 in the middle*/){
            return true;
        }//comment 3
        /* comment4 multilines
        still comment 4*/
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

