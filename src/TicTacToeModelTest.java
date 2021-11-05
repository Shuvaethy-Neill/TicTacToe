import static org.junit.Assert.*;

public class TicTacToeModelTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void getStatusForInitialTicTacToe() {
        TicTacToeModel tttm = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, tttm.getStatus());
    }

    @org.junit.Test
    public void getStatusAfterFirstMove() {
        TicTacToeModel tttm = new TicTacToeModel();
        tttm.play(1, 1);
        assertEquals(TicTacToeModel.Status.UNDECIDED, tttm.getStatus());
    }
}