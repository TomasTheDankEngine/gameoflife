package gameoflife;

public class Gameoflife {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        String[][] board = new String[10][10];
        int count = 0;
        System.out.println("Init board:\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (Math.random() < 0.5) {
                    board[i][j] = "X";
                } else {
                    board[i][j] = ".";
                }
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("--------------------------------------------------");
        for (int i = 1; i <= 50; i++) {
            for (int k = 0; k < board.length; k++) {
                for (int l = 0; l < board[k].length; l++) {
                    if (k == 0) {
                        if (l == 0) {
                            if (board[k + 1][l] == "X") {
                                count++;
                            }
                            if (board[k][l + 1] == "X") {
                                count++;
                            }
                        } else if (l == board.length - 1) {
                            if (board[k + 1][l] == "X") {
                                count++;
                            }
                            if (board[k][l - 1] == "X") {
                                count++;
                            }
                        }
                    } else if (k == board.length - 1) {
                        if (l == 0) {
                            if (board[k - 1][l] == "X") {
                                count++;
                            }
                            if (board[k][l + 1] == "X") {
                                count++;
                            }
                        } else if (l == board.length - 1) {
                            if (board[k - 1][l] == "X") {
                                count++;
                            }
                            if (board[k][l - 1] == "X") {
                                count++;
                            }
                        }
                    } else {
                        if (board[k - 1][l] == "X") {
                            count++;
                        }
                        if (board[k + 1][l] == "X") {
                            count++;
                        }
                        if (l != 0 && board[k][l - 1] == "X") {
                            count++;
                        }
                        if (l != (board[k].length - 1) && board[k][l + 1] == "X") {
                            count++;
                        }
                    }
                    if (board[k][l] == "." && count == 3) {
                        board[k][l] = "X";
                    } else if (board[k][l] == "X" && count == 2 | count == 3) {
                        board[k][l] = "X";
                    } else if (board[k][l] == "X" && count < 2 | count > 3) {
                        board[k][l] = ".";
                    }
                    System.out.print(board[k][l] + "\t");
                    count = 0;
                }
                System.out.print("\n");
            }
            Thread.sleep(100);
            System.out.print("\n----------");
            clearScreen();
        }
    }
}
