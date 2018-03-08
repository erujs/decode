package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eru on 3/19/2017.
 */
public class GUI extends JFrame {

    private JPanel contentPane;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton btnSubmit;
    private Game game;
    private JLabel lblHI;
    private int but1=0,but2=0,but3=0,but4=0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void disableButtons(){
        button.setEnabled(false);
        button_1.setEnabled(false);
        button_2.setEnabled(false);
        button_3.setEnabled(false);
        btnSubmit.setEnabled(false);
    }
    public void enableButtons(){
        button.setEnabled(true);
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        btnSubmit.setEnabled(true);
    }

    public GUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 375, 318);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        JMenu mnNewGame = new JMenu("New Game");
        mnMenu.add(mnNewGame);

        JMenuItem mntmEasy = new JMenuItem("Easy");
        mntmEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                game=new Game(1);
                but1=0;but2=0;but3=0;but4=0;
                enableButtons();
                button.setText(""+but1); button_1.setText(""+but2);
                button_2.setText(""+but3); button_3.setText(""+but4);
                System.out.println(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
                //lblHI.setText(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
            }
        });
        mnNewGame.add(mntmEasy);

        JMenuItem mntmMedium = new JMenuItem("Medium");
        mntmMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game=new Game(2);
                enableButtons();
                button.setText(""+but1); button_1.setText(""+but2);
                button_2.setText(""+but3); button_3.setText(""+but4);
                System.out.println(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
                //lblHI.setText(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
                but1=0;but2=0;but3=0;but4=0;
            }
        });
        mnNewGame.add(mntmMedium);

        JMenuItem mntmHard = new JMenuItem("Hard");
        mntmHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game=new Game(3);
                enableButtons();
                button.setText(""+but1); button_1.setText(""+but2);
                button_2.setText(""+but3); button_3.setText(""+but4);
                System.out.println(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
                //lblHI.setText(game.combo.get(0)+" - "+game.combo.get(1)+" - "+game.combo.get(2)+" - "+game.combo.get(3));
                but1=0;but2=0;but3=0;but4=0;
            }
        });
        mnNewGame.add(mntmHard);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        mnMenu.add(mntmExit);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        button = new JButton("");
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                button.setText(""+(++but1));
                if(but1==game.max())
                    but1=-1;
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 27));
        button.setBounds(10, 42, 79, 86);
        contentPane.add(button);

        button_1 = new JButton("");
        button_1.setEnabled(false);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                button_1.setText(""+(++but2));
                if(but2==game.max())
                    but2=-1;
            }
        });
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
        button_1.setBounds(99, 42, 79, 86);
        contentPane.add(button_1);

        button_2 = new JButton("");
        button_2.setEnabled(false);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                button_2.setText(""+(++but3));
                if(but3==game.max())
                    but3=-1;
            }
        });
        button_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
        button_2.setBounds(188, 42, 79, 86);
        contentPane.add(button_2);

        button_3 = new JButton("");
        button_3.setEnabled(false);
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                button_3.setText(""+(++but4));
                if(but4==(game.max()+1)){
                    button_3.setText("0");
                    but4=-1;
                }
            }
        });
        button_3.setFont(new Font("Tahoma", Font.PLAIN, 27));
        button_3.setBounds(277, 42, 79, 86);
        contentPane.add(button_3);

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setEnabled(false);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.combandguess();
                game.guess.add(Integer.parseInt(button.getText())); game.guess.add(Integer.parseInt(button_1.getText()));
                game.guess.add(Integer.parseInt(button_2.getText())); game.guess.add(Integer.parseInt(button_3.getText()));
                if(game.attempt==game.stop) {
                    JOptionPane.showMessageDialog(null, "Game Over\n");
                    disableButtons();
                }
                if(game.isCorrect(game.guess, game.combination)){
                    JOptionPane.showMessageDialog(null, "You Win\n");
                    disableButtons();
                }
                game.hint(game.guess, game.combination);
                lblHI.setText(game.clues[0]+"   "+game.clues[1]+"   "+game.clues[2]+"   "+game.clues[3]);
                game.attempt++;
            }
        });
        btnSubmit.setBounds(99, 139, 168, 30);
        contentPane.add(btnSubmit);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        verticalBox.setBounds(24, 180, 317, 72);
        contentPane.add(verticalBox);

        lblHI = new JLabel("H - I - N - T");
        lblHI.setFont(new Font("Century Gothic", Font.BOLD, 58));
        verticalBox.add(lblHI);
    }
}