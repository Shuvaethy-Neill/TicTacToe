import static org.junit.Assert.*;

public class TicTacToeModelTest {

    private TicTacToeModel tttm = new TicTacToeModel();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void getStatusForInitialTicTacToe() {
        assertEquals(TicTacToeModel.Status.UNDECIDED, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterFirstMove() {
        tttm.play(1, 1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterHorizontalWin() {
        tttm.play(1, 1);
        tttm.play(2, 1);
        tttm.play(1, 0);
        tttm.play(2, 2);
        tttm.play(1, 2);
        assertEquals(TicTacToeModel.Status.X_WON, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterVerticalWin() {
        tttm.play(0, 1);
        tttm.play(0, 2);
        tttm.play(1, 0);
        tttm.play(1, 2);
        tttm.play(1, 1);
        tttm.play(2, 2);
        assertEquals(TicTacToeModel.Status.O_WON, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterDiagonalLeftWin() {
        tttm.play(0, 0);
        tttm.play(2, 0);
        tttm.play(1, 1);
        tttm.play(0, 1);
        tttm.play(2, 2);
        assertEquals(TicTacToeModel.Status.X_WON, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterDiagonalRightWin() {
        tttm.play(0, 0);
        tttm.play(0, 2);
        tttm.play(0, 1);
        tttm.play(1, 1);
        tttm.play(2, 2);
        tttm.play(2, 0);
        assertEquals(TicTacToeModel.Status.O_WON, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterTie() {
        tttm.play(0, 0);
        tttm.play(0, 1);
        tttm.play(0, 2);
        tttm.play(1, 0);
        tttm.play(1, 1);
        tttm.play(2, 0);
        tttm.play(2, 1);
        tttm.play(1, 2);
        tttm.play(2, 2);
        assertEquals(TicTacToeModel.Status.TIE, tttm.getStatus());
    }
}