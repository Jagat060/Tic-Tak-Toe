import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Tictaktoe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame("TicTakToe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean game_over = false;


    Tictaktoe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(50,50,50));

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 80));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tak-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

        }
    public void actionPerformed(ActionEvent e ){
        for (JButton button : buttons) {
            if (e.getSource() == button) {
                if (player1_turn) {
                    if (button.getText().isEmpty()) {
                        button.setForeground(new Color(255, 0, 0));
                        button.setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (button.getText().isEmpty()) {
                        button.setForeground(new Color(0, 0, 255));
                        button.setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
        }
    public void firstTurn(){
        if(random.nextInt(2)==0) {
            player1_turn = true;
            textField.setText("X turn");
        }
            else{
                player1_turn = false;
                textField.setText("O turn");
            }

    }
    public void check(){
        //checking X winning conditions.
        if((buttons[0].getText().equals("X") && buttons[1].getText().equals("X")
                && buttons[2].getText().equals("X"))){
            xWins(0,1,2);
        }
        if((buttons[3].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[5].getText().equals("X"))){
            xWins(3,4,5);
        }
        if((buttons[6].getText().equals("X") && buttons[7].getText().equals("X")
                && buttons[8].getText().equals("X"))){
            xWins(6,7,8);
        }
        if((buttons[0].getText().equals("X") && buttons[3].getText().equals("X")
                && buttons[6].getText().equals("X"))){
            xWins(0,3,6);
        }
        if((buttons[1].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[7].getText().equals("X"))){
            xWins(1,4,7);
        }
        if((buttons[2].getText().equals("X") && buttons[5].getText().equals("X")
                && buttons[8].getText().equals("X"))){
            xWins(2,5,8);
        }
        if((buttons[0].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[8].getText().equals("X"))){
            xWins(0,4,8);
        }
        if((buttons[2].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[6].getText().equals("X"))){
            xWins(2,4,6);
        }

        if((buttons[0].getText().equals("O") && buttons[1].getText().equals("O")
                && buttons[2].getText().equals("O"))){
            oWins(0,1,2);
        }
        if((buttons[3].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[5].getText().equals("O"))){
            oWins(3,4,5);
        }
        if((buttons[6].getText().equals("O") && buttons[7].getText().equals("O")
                && buttons[8].getText().equals("O"))){
            oWins(6,7,8);
        }
        if((buttons[0].getText().equals("O") && buttons[3].getText().equals("O")
                && buttons[6].getText().equals("O"))){
            oWins(0,3,6);
        }
        if((buttons[1].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[7].getText().equals("O"))){
            oWins(1,4,7);
        }
        if((buttons[2].getText().equals("O") && buttons[5].getText().equals("O")
                && buttons[8].getText().equals("O"))){
            oWins(2,5,8);
        }
        if((buttons[0].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[8].getText().equals("O"))){
            oWins(0,4,8);
        }
        if((buttons[2].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[6].getText().equals("O"))){
            oWins(2,4,6);
        }

        else if(isBoardFull() && !game_over){
            textField.setText("Tie");
            for (JButton button : buttons) {
                button.setEnabled(false);
                button.setBackground(Color.GREEN);
            }
        }

    }
    public void xWins(int a, int b , int c){
        game_over = true;
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        buttons[a].setOpaque(true);
        buttons[b].setOpaque(true);
        buttons[c].setOpaque(true);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("X wins");
    }
    public void oWins(int a, int b , int c){
        game_over = true;
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        buttons[a].setOpaque(true);
        buttons[b].setOpaque(true);
        buttons[c].setOpaque(true);

        for (JButton button : buttons) {
            button.setEnabled(false);
        }
        textField.setText("O wins");
    }
    public boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
