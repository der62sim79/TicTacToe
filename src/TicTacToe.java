
import java.util.Scanner;

public class TicTacToe {
    static boolean isThereAnWinner = false;
    static boolean isPlayer1 = true;

    public static void main(String[] args) {


        String winner = "";


        char field[][] = new char[3][3];
        char ch = '-';

        printField(field, ch);

        while (true) {
            askUserAndSetPosition(field);
            printField(field, ch);

            isThereAWinner(field, ch);
            isPlayer1 = !isPlayer1;

            if (isThereAnWinner) {
                printField(field, ch);
                System.exit(0);
            }


        }
    }

    private static void askUserAndSetPosition(char[][] field) {
        int position;
        boolean isAlreadySet = true;
        while (isAlreadySet) {
            isAlreadySet = false;
            if (isPlayer1) {
                System.out.println("Spieler1 bitte geben Sie eine Zahl zwischen 1-9 ein: ");
            } else {
                System.out.println("Spieler2 bitte geben Sie eine Zahl zwischen 1-9 ein: ");
            }

            Scanner input = new Scanner(System.in);
            String firstPlayer = input.nextLine();
            position = Integer.parseInt(firstPlayer);


            if (position <= 9 && position > 0) {
                if (isPlayer1) {
                    isAlreadySet = setMyField(position, 'X', field);

                } else {
                    isAlreadySet = setMyField(position, 'O', field);

                }
            } else {
                isAlreadySet = true;
                System.out.println("Bitte geben Sie nur zahlen zwischen 1-9 ein");

            }

            if (isAlreadySet) {
                System.out.println("Belegt....");
            }
        }
    }

    private static void isThereAWinner(char[][] field, char ch) {
        diagonalControlOfWinner(field, ch);
        colControlOfWinner(field, ch);
        diagonalControlOfWinner(field, ch);

    }

    private static void diagonalControlOfWinner(char[][] field, char ch) {
        if (field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[0][0] != ch) {
            if (field[0][0] == 'X') {
                System.out.println("X hat gewonnen");
                isThereAnWinner = true;
            }
            if (field[0][0] == 'O') {
                System.out.println("O hat gewonnen");
                isThereAnWinner = true;
            }
        }
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[0][0] != ch) {
            if (field[0][2] == 'X') {
                System.out.println("X hat gewonnen");
                isThereAnWinner = true;
            }
            if (field[0][2] == 'O') {
                System.out.println("O hat gewonnen");
                isThereAnWinner = true;
            }
        }
    }

    private static void colControlOfWinner(char[][] field, char ch) {
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == field[1][j] && field[1][j] == field[2][j] && field[0][j] != ch) {
                if (field[0][j] == 'X') {
                    System.out.println("X hat gewonnen");
                    isThereAnWinner = true;
                }
                if (field[0][j] == 'O') {
                    System.out.println("0 hat gewonnen");
                    isThereAnWinner = true;
                }
            }
        }
    }

    private static void rowControlOfWinner(char[][] field, char ch) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][0] != ch) {
                if (field[i][0] == 'X') {
                    System.out.println("X hat gewonnen");
                    isThereAnWinner = true;
                }
                if (field[i][0] == 'O') {
                    System.out.println("O hat gewonnen");
                    isThereAnWinner = true;
                }
            }
        }
    }

    /*
     *   ACHTUNG Reafactoring - besser LÖSUNG suchen
     */
    private static boolean setMyField(int playersChoice, char choiceChar, char[][] field) {
        switch (playersChoice) {
            case 1:
                if (field[0][0] != '-') {
                    return true;
                }
                field[0][0] = choiceChar;
                return false;

            case 2:
                if (field[0][1] != '-') {
                    return true;
                }
                field[0][1] = choiceChar;
                return false;
            case 3:
                if (field[0][2] != '-') {
                    return true;
                }
                field[0][2] = choiceChar;
                return false;
            case 4:
                if (field[1][0] != '-') {
                    return true;
                }
                field[1][0] = choiceChar;
                return false;
            case 5:
                if (field[1][1] != '-') {
                    return true;
                }
                field[1][1] = choiceChar;
                return false;
            case 6:
                if (field[1][2] != '-') {
                    return true;
                }
                field[1][2] = choiceChar;
                return false;
            case 7:
                if (field[2][0] != '-') {
                    return true;
                }
                field[2][0] = choiceChar;
                return false;
            case 8:
                if (field[2][1] != '-') {
                    return true;
                }
                field[2][1] = choiceChar;
                return false;
            case 9:
                if (field[2][2] != '-') {
                    return true;
                }
                field[2][2] = choiceChar;
                return false;

        }
        return false;
    }

    private static void printField(char[][] field, char ch) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

                if (field[i][j] != 'X' && field[i][j] != 'O') {
                    field[i][j] = ch;
                }
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}