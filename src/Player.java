import java.util.Random;

public class Player {
    public static int random() {
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public static int OnlyRock() {
        return 0;
    }

    public static int Input(String msg) {

        if (msg.equals("rock")) {
            return 0;
        } else if (msg .equals("scissor")) {
            return 1;
        } else
            return 2;
    }

    public static int Cycle(int i){

       if(i>=2||i==-1)return 0;
       else return i+=1;

    }
}
