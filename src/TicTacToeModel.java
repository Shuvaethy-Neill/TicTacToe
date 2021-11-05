import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    //state of object
    private char[][] grid;
    private boolean turn;
    private int marks;
    private Status status;
    private List<TicTacToeView> views;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
    }

    public void addTicTacToeView(TicTacToeView view){
        views.add(view);
    }

    public void removeTicTacToeView(TicTacToeView view){
        views.remove(view);
    }

    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    //this should update the status
    private void updateStatus() {
        boolean win = false;

        //find horizontal line win
        for(int column = 0; column < TicTacToeModel.SIZE; column++){
            char first = this.grid[0][column];
            if(first != ' '){
                for(int row = 1; row < TicTacToeModel.SIZE; row++){
                    if(first != this.grid[row][column]){
                        win = false;
                    }
                    else {
                        win = true;
                    }
                }
                if (win){
                    if(first == 'X'){
                        this.status = Status.X_WON;
                    }
                    else{
                        this.status = Status.O_WON;
                    }
                }
            }
        }

        //find horizontal line win
        for(int row = 0; row < TicTacToeModel.SIZE; row++){
            char first = this.grid[row][0];
            if(first != ' '){
                win = true;
                for(int column = 1; column < TicTacToeModel.SIZE; column++){
                    if(first != this.grid[row][column]){
                        win = false;
                    }
                }
                if (win){
                    if(first == 'X'){
                        this.status = Status.X_WON;
                    }
                    else{
                        this.status = Status.O_WON;
                    }
                }
            }
        }

        //left to right diagonal
        char first = this.grid[0][0];
        if(first != ' '){
            win = true;
            for(int x = 1; x < TicTacToeModel.SIZE; x++){
                if(first != this.grid[x][x]){
                    win = false;
                }
            }
            if (win){
                if(first == 'X'){
                    this.status = Status.X_WON;
                }
                else{
                    this.status = Status.O_WON;
                }
            }

        }

        //right to left diagonal
        first = this.grid[0][TicTacToeModel.SIZE-1];
        if(first != ' '){
            win = true;
            for(int x = 1; x < TicTacToeModel.SIZE; x++){
                if(first != this.grid[x][TicTacToeModel.SIZE - 1 - x]){
                    win = false;
                }
            }
            if (win){
                if(first == 'X'){
                    this.status = Status.X_WON;
                }
                else{
                    this.status = Status.O_WON;
                }
            }

        }
        if (marks == TicTacToeModel.SIZE *  TicTacToeModel.SIZE ){
            this.status = Status.TIE;
        }
    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        //if grid is not empty then ignore
        if (grid[x][y] != ' ') return;
        //if the turn is true then return 'X', otherwise return 'O' if false
        grid[x][y] = turn? 'X' : 'O';
        marks++;
        updateStatus();
        System.out.println(status);
        for(TicTacToeView view: views){
            view.handleTicTacToeStatusUpdate(new TicTacToeEvent(this, status, x, y));
        }
        changeTurn();
    }
}

