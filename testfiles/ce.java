public class ce {
   //The "confusing Else"
    public void confElse(){
        int age = 0;
        if(age < 20){
            age = 0;
        }else{
            if (age>40) {
                age = 20;
            }else {
                age -= 20;
            }
        }
    }
}
