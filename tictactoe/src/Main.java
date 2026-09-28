//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    vscomputer();
    //twoplayer();

}
private void vscomputer(){
    Scanner input = new Scanner(System.in);
    Utility util = new Utility();
    IO.println("Tell me the length of width of board that you want");
    int size = Integer.parseInt(input.nextLine());
    IO.println("Player 1 Tell me your name it should not be com");
    String playerOne = util.getPlayorSymbol(input);
    String[][] table = new String[size][size];
    util.boardinit(table);
    int turn = 1;
    while (true) {
        util.draw(table);
        String currentPlayer = turn % 2 == 0 ? "com" : playerOne;
        int x=0;
        int y=0;
        if(turn%2!=0) {
             x = util.getValidInteger(input, table.length, "select  valid row where you want to put your symbol");
             y = util.getValidInteger(input, table.length, "select valid column where you want to put your symbol");
            while (!table[x][y].isBlank()) {
                x = util.getValidInteger(input, table.length, "select valid row where you want to put your symbol");
                y = util.getValidInteger(input, table.length, "select valid column where you want to put your symbol");
            }
        }else{
            List<Integer> possiblePosition=util.getRandomAvailablePos(table);

             x=possiblePosition.get(0);
             y=possiblePosition.get(1);
        }
        turn++;
        table[x][y] = currentPlayer;
        if (util.checkWinConditionHere(table, currentPlayer, x, y)) {
            util.draw(table);
            IO.println(currentPlayer + " win");
            break;
        } else if (util.checkAllOccupied(table)) {
            util.draw(table);
            IO.println("draw between player one and player two");
            break;
        }
    }
}
private void twoplayer() {
    Scanner input = new Scanner(System.in);
    Utility util = new Utility();
    IO.println("Tell me the length of width of board that you want");
    int size = Integer.parseInt(input.nextLine());
    IO.println("Player 1 Tell me your name");
    String playerOne = util.getPlayorSymbol(input);
    IO.println("Player 2 Tell me your name");
    String playerTwo = util.getPlayorSymbol(input);
    String[][] table = new String[size][size];
    util.boardinit(table);
    int turn = 1;
    while (true) {
        util.draw(table);
        int x =util.getValidInteger(input,table.length,"select  valid row where you want to put your symbol");
        int y = util.getValidInteger(input,table.length,"select valid column where you want to put your symbol");
        while(!table[x][y].isBlank()){
            x =util.getValidInteger(input,table.length,"select valid row where you want to put your symbol");
            y = util.getValidInteger(input,table.length,"select valid column where you want to put your symbol");
        }
        String currentPlayer = turn % 2 == 0 ? playerTwo : playerOne;
        turn++;

        table[x][y] = currentPlayer;
        if (util.checkWinConditionHere(table, currentPlayer, x, y)) {
            util.draw(table);
            IO.println(currentPlayer + " win");
            break;
        } else if (util.checkAllOccupied(table)) {
            util.draw(table);
            IO.println("draw between player one and player two");
            break;
        }
    }
}


