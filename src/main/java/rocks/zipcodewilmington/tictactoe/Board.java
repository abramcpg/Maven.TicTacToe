package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character winner = ' '; //for declaring the winner to
    public Board(Character[][] matrix) { //constructor
        Character temp = ' '; //to hold the value of the winner
        temp = cycleRows(matrix);
        winner = temp;
        temp = cycleColumns(matrix);
        if (temp != ' ') winner = temp;
        temp = checkDiagonals(matrix);
        if (temp != ' ') winner = temp;
    }

    public Boolean isInFavorOfX() { return winner == 'X';} //returns true if statement is true

    public Boolean isInFavorOfO() { return winner == 'O';} //returns false if statement is false

    public Boolean isTie() { return winner == ' ';}

    public String getWinner() {
        if (winner == ' ') return "";
        return winner.toString();
    }

    public char row(Character[][] matrix,Integer rowNum) { //check if a row holds 3 of the same value
        if (matrix[rowNum][0] == matrix[rowNum][1] && matrix[rowNum][0] == matrix[rowNum][2]) {
            return matrix[rowNum][0];
        }
        return ' ';
    }

    public char cycleRows(Character[][] matrix){ //to cycle between the 3 rows
        char temp=' ';
        for (int i=0;i<3;i++){
            temp = row(matrix,i);
            if (temp!=' ') return temp;
        }
        return ' ';
    }

    public char checkColumn(Character[][] matrix,Integer colNum) {
        if (matrix[0][colNum] == matrix[1][colNum] && matrix[0][colNum] == matrix[2][colNum]) {
            return matrix[0][colNum];
        }
        return ' ';
    }

    public char cycleColumns(Character[][] matrix){
        char temp=' ';
        for (int i=0;i<3;i++){
            temp = checkColumn(matrix,i);
            if (temp!=' ') return temp;
        }
        return ' ';
    }

    public char checkDiagonals(Character[][] matrix){ //brute force checking for diagonal wins
        if (matrix[1][1]==' ') return ' '; //if the middle index is blank, there can be no diagonal win
        if((matrix[0][0]==matrix[1][1] && matrix[1][1]==matrix[2][2])||
                (matrix[0][2]==matrix[1][1] && matrix[1][1]==matrix[2][0]))
            return matrix[1][1];
        return ' ';
    }
}
