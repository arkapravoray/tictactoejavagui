import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] button = new JButton[9];
    boolean player_1_turn;
    int c=0;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 50, 25));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("TIC-TAC-TOE");
        textField.setOpaque(true);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 800, 100);
        panel.add(textField);
        frame.add(panel, BorderLayout.NORTH);
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(125, 125, 125));
       
        frame.add(button_panel);
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            button[i].setBackground(new Color(100,100,0));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
            
           
        }
        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int i;
        for ( i = 0; i < 9; i++) {
            c++;
            if (e.getSource() == button[i]) {
                if (player_1_turn) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(255, 0, 0));
                        button[i].setText("X");
                        player_1_turn = false;
                        textField.setText("O's Turn");
                      check();
                      
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 255, 0));
                        button[i].setText("O");
                        player_1_turn = true;
                        textField.setText("X's Turn");
                        check();
                    }
        

                }
                
               
            }
         

        }

        if(c==81&&check()==true){
            Draw();
        }
        
    }
    
        

    

    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player_1_turn = true;
            textField.setText("X's Turn");
        } else {
            player_1_turn = false;
            textField.setText("O's turn");
        }

    }

    public boolean check() {
        
        if (button[0].getText() == "X" && button[1].getText() == "X" && button[2].getText() == "X")
            {xWins(0, 1, 2);return false;}
        if (button[3].getText() == "X" && button[4].getText() == "X" && button[5].getText() == "X")
            {xWins(3, 4, 5);  return false;}
        if (button[6].getText() == "X" && button[7].getText() == "X" && button[8].getText() == "X")
           { xWins(6, 7, 8);  return false;}
        if (button[0].getText() == "X" && button[3].getText() == "X" && button[6].getText() == "X")
            {xWins(0, 3, 6);  return false;}
        if (button[1].getText() == "X" && button[4].getText() == "X" && button[7].getText() == "X")
            {xWins(1, 4, 7);  return false;}
        if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X")
            {xWins(2, 5, 8);  return false;}
        if (button[0].getText() == "X" && button[4].getText() == "X" && button[8].getText() == "X")
            {xWins(0, 4, 8);  return false;}
        if (button[2].getText() == "X" && button[4].getText() == "X" && button[6].getText() == "X")
            {xWins(2, 4, 6);  return false;}

        if (button[0].getText() == "O" && button[1].getText() == "O" && button[2].getText() == "O")
            {oWins(0, 1, 2);  return false;}
        if (button[3].getText() == "O" && button[4].getText() == "O" && button[5].getText() == "O")
            {oWins(3, 4, 5); return false;}
        if (button[6].getText() == "O" && button[7].getText() == "O" && button[8].getText() == "O")
            {oWins(6, 7, 8); return false;}
        if (button[0].getText() == "O" && button[3].getText() == "O" && button[6].getText() == "O")
            {oWins(0, 3, 6); return false; }
        if (button[1].getText() == "O" && button[4].getText() == "O" && button[7].getText() == "O")
            {oWins(1, 4, 7); return false;}
        if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O")
            {oWins(2, 5, 8); return false;}
        if (button[0].getText() == "O" && button[4].getText() == "O" && button[8].getText() == "O")
            {oWins(0,4,8); return false;}
        if (button[2].getText() == "O" && button[4].getText() == "O" && button[6].getText() == "O")
            {oWins(2, 4, 6); return false;}
            return true;
    }

    public void xWins(int a, int b, int c) {
       button[a].setBackground(Color.BLUE);
       button[b].setBackground(Color.BLUE);
       button[c].setBackground(Color.BLUE);
       for(int i=0;i<9;i++){
           button[i].setEnabled(false);
       }
       textField.setText("X Wins");
    }

    public void oWins(int a, int b, int c) {
        button[a].setBackground(Color.BLUE);
        button[b].setBackground(Color.BLUE);
        button[c].setBackground(Color.BLUE);
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textField.setText("O Wins");
     }
     public void Draw(){
        for(int i=0;i<9;i++){
            button[i].setEnabled(false);
        }
        textField.setText("Draw!!");
     }   
     }
    

