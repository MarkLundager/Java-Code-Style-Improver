public class Ifrt {       
    int x = 4;

    public static void main(String[] args) {
        eifb(2);
    }

    
    public boolean eifb(int y){
        if(x>/*Comment in middle of expression*/y){
        }//comment here as well
        else{
            return/*this is a crazy comment location*/ false;
        }
    }




    public boolean eifb2(int y){
        if(!(x > y)){
            return false;
        }
    }

}

