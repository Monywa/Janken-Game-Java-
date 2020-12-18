public class Judgment {

    public static String Judge(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Even.";
        } else {
            if (player1.equals("Rock") && player2.equals("Scissor") || player1.equals("Scissor") && player2.equals("Paper") ||
                    player1.equals("Paper") && player2.equals("Rock"))
                return "Player 1 wins.";
            else
                return "Player 2 wins.";
        }
    }


}
