import java.util.Random;
import java.util.Scanner;

public class Janken {
    public static int p1win = 0;
    public static int p2win = 0;

    public static int random1 =-1;

    public static int random2 = -1;

    public static void main(String[] args) {
        String result = "";
        Scanner in = new Scanner(System.in);

        System.out.println("[Start Jaken]\n");


        for (int i = 0; i < 3; i++) {
            Round(i);
            StartMatch(); // main part
        }

        System.out.println("\n\n");
        System.out.println("[End Janken]");

        System.out.print("The score is " + p1win + "-" + p2win + ".");

        if (p1win > p2win) {
            result = "Player 1 wins.";
        } else result = "Player 2 wins.";

        System.out.println(result);


    }

    public static String Tools(int random) {
        if (random == 0) {
            return "Rock";
        } else if (random == 1) {
            return "Scissor";
        } else
            return "Paper";
    }

    public static void Round(int i) {
        if (i == 0) {
            System.out.println("[First Play]");
        } else if (i == 1) {
            System.out.println("[Second Play]");

        } else System.out.println("[Third Play]");

    }

    public static void StartMatch() {
//        Random rand = new Random();
//        int random1 = rand.nextInt(4);


        Scanner s = new Scanner(System.in);
        System.out.println("Please choose strategy of Janken)");
        System.out.println("eg. Random, OnlyRock, Cycle, Input\n");

        System.out.println("For Player 1");
        String input1 = s.nextLine();

        random1 = strategyInput(input1, random1);

        System.out.println("For Player 2");
        String input2 = s.nextLine();


        random2 = strategyInput(input2, random2);


        String player1 = Tools(random1);
        String player2 = Tools(random2);

        Judgment jug = new Judgment();

        System.out.println(player1 + " vs " + player2);

        String result = jug.Judge(player1, player2);

        System.out.println(result);
        System.out.println();


        if (result == "Player 1 wins.") {
            p1win++;
        } else if (result == "Player 2 wins.") {
            p2win++;
        } else
            StartMatch();


    }

    public static Boolean error(String input){
        if(input.equals("rock")||input.equals("paper")||input.equals("scissor")){
            return false;
        }return true;
    }

    private static int strategyInput(String strategy, int previous) {
        Player player = new Player();
        Scanner sc = new Scanner(System.in);
        if (strategy.toLowerCase().equals("onlyrock")) {
            return player.OnlyRock();

        } else if (strategy.toLowerCase().equals("cycle")) {
            return player.Cycle(previous);


        } else if (strategy.toLowerCase().equals("input")) {
            System.out.println("Please enter scissor, rock , paper");

            String input = sc.nextLine();
            while(error(input.toLowerCase())){

                System.out.println("Wrong format , Please enter  scissor, rock , paper");

                input = sc.nextLine();


            }return player.Input(input.toLowerCase());
        } else if(strategy.toLowerCase().equals("")||strategy.toLowerCase().equals("random")){

            return player.random();

        }else
            System.out.println("Wrong format Please retry again");
        String retry= sc.nextLine();
        return strategyInput(retry,previous);
    }
}
