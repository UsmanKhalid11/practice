import java.io.IO;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    public boolean checkWinConditionHere(String[][] board, String player, int x, int y) {
        if (x == y) {
            return checkRow(board, player, x) || checkColumn(board, player, y) || checkDiagnol(board, player) || checkOppositeDiagnol(board, player);
        } else if (x + y == board.length - 1) {
            return checkRow(board, player, x) || checkColumn(board, player, y) || checkDiagnol(board, player) || checkOppositeDiagnol(board, player);
        } else {
            return checkRow(board, player, x) || checkColumn(board, player, y);
        }
    }

    public boolean checkColumn(String[][] board, String player, int y) {
        for (int i = 0; i < board.length; i++) {
            if (!board[i][y].equals(player)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(String[][] board, String player, int x) {
        for (int i = 0; i < board.length; i++) {
            if (!board[x][i].equals(player)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkOppositeDiagnol(String[][] board, String player) {
        for (int i = 0, size = board.length - 1; i < board.length; i++, size--) {
            if (!board[i][size].equals(player)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagnol(String[][] board, String player) {
        for (int i = 0; i < board.length; i++) {
            if (!board[i][i].equals(player)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAllOccupied(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void boardinit(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public String getPlayorSymbol(Scanner input) {
        String playerSymbol = null;
        while (playerSymbol == null || playerSymbol.isBlank() ||playerSymbol.length()>3 || playerSymbol.equals("com")) {
            IO.println("player symbol cannot be empty, lengh should not be greater than 3 and player symbol should not be com");
            playerSymbol = input.nextLine();
        }
        return playerSymbol;
    }

    public int getValidInteger(Scanner input, int size,String message) {
        int x = -22;
        while (x <= 0 || x > size ) {
            IO.println(message);
            x = Integer.parseInt(input.nextLine());
        }
        return x-1;

    }

    public void draw(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            IO.print(" ");
            for (int j = 0; j < board.length; j++) {

                 if (j == board.length - 1) {
                    IO.print(board[i][j]);
                } else {
                    IO.print(  board[i][j] + " | ");
                }
            }
            IO.println();
            String boundary = "------";
            if (i != board.length-1) {
                for (int j = 0; j < board.length; j++) {
                    IO.print(boundary);
                }
            }

            IO.println();
        }

    }
    public ArrayList<List<Integer>> getAllEmptyList(String[][] board) {
        ArrayList<List<Integer>> currentEmpty= new ArrayList<>();
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
              if(isCurrentPositionEmpty(board,i,j)){
                  currentEmpty.add(List.of(i,j));
              }

            }
        }
        return currentEmpty;
    }
    public boolean isCurrentPositionEmpty(String[][] board,int x, int y){
        return  board[x][y].equals(" ");
    }
    public List<Integer> getRandomAvailablePos(String[][] board){
        ArrayList<List<Integer>> emptyPositions=getAllEmptyList(board);
        int min=0;
        int max=emptyPositions.size()-1;
        return emptyPositions.get(ThreadLocalRandom.current().nextInt(emptyPositions.size()));
    }
}
