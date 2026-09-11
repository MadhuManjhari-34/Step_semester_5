package core_java.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the outcome of a single round.
     *
     * @param playerMove   Move made by the player
     * @param computerMove Move made by the computer
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void runSimulation(int rounds, String[] predefinedMoves) {
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] history = new String[rounds][4];

        for (int i = 0; i < rounds; i++) {
            String playerMove;
            if (predefinedMoves != null && i < predefinedMoves.length) {
                playerMove = predefinedMoves[i];
            } else {
                playerMove = MOVES[random.nextInt(MOVES.length)];
            }

            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            history[i][0] = String.valueOf(i + 1);
            history[i][1] = playerMove;
            history[i][2] = computerMove;
            history[i][3] = result;
        }

        System.out.println("==========================================================");
        System.out.printf("%-8s | %-12s | %-14s | %-12s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("==========================================================");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8s | %-12s | %-14s | %-12s%n",
                    history[i][0], history[i][1], history[i][2], history[i][3]);
        }
        System.out.println("==========================================================");

        double winPercentage = ((double) wins / rounds) * 100.0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        System.out.println("--- Rock-Paper-Scissors Live Demo (5 Rounds) ---");
        String[] sampleDemoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        runSimulation(5, sampleDemoMoves);
    }
}
