import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame  implements TicTacToeView{

    private JButton[][] buttons;

    public TicTacToeFrame(){
        super("Tic Tac Toe!");

        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));

        TicTacToeModel model = new TicTacToeModel();

        model.addTicTacToeView(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        //TicTacToeController tttc = new TicTacToeController(model);

        for(int i = 0; i < TicTacToeModel.SIZE; i++){
            for(int j = 0; j < TicTacToeModel.SIZE; j++){
                JButton button = new JButton(" ");
                //button.setActionCommand(i + " " + j);
                buttons[i][j] = button;
                int x = i;
                int y = j;
                button.addActionListener(e -> model.play(x, y));
                this.add(button);

            }
        }
        this.setVisible(true);
    }

    @Override
    public void handleTicTacToeStatusUpdate(TicTacToeEvent e) {
        TicTacToeModel ticTacToeModel = (TicTacToeModel) e.getSource();
        String label = ticTacToeModel.getTurn()? "X" : "O";
        buttons[e.getX()][e.getY()].setText(label);

        if(e.status == TicTacToeModel.Status.O_WON || e.status == TicTacToeModel.Status.X_WON || e.status == TicTacToeModel.Status.TIE){
            String result;
            if(e.status == TicTacToeModel.Status.O_WON){
                result = "O has won.";
            }
            else if(e.status == TicTacToeModel.Status.X_WON){
                result = "X has won.";
            }
            else{
                result = "You both have tied.";
            }
            JOptionPane.showMessageDialog(this, "Game over! " + result + " Game will now close.");
            setVisible(false);
            dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }
}
