public class eifb {
    public static void main(String[] args) {
        
        int[] x = { 1, 2, 3, 4, 5, 6, 7, 8 };

        eifb EIFB = new eifb();
        EIFB.eifbody(x);
    }

    public void eifbody(int[] values){
        int j = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i]%2 == 0 ){

            }else{
                j++;
            }
        }
    }

    public void eeb(int[] values) {
        int j = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i]%2 == 0 ){
                j++;

            }else{
            }

        }

    }
}
