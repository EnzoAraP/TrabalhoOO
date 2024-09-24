package dcc025.genius;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Game extends JFrame {
    private ArrayList<Integer> sequence;
    private int currentStep;
    private JButton[] buttons;
    private Random random;
    private boolean userTurn;
    Competicao teste;
    int tamanhoa=0;

    public Game(Competicao a) {
        teste=a;
        sequence = new ArrayList<>();
        currentStep = 0;
        random = new Random();
        userTurn = false;

        // Configuração da interface
        setTitle("Genius Game");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(getColor(i));
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            buttons[i].addActionListener(new ButtonClickListener(i));
            add(buttons[i]);
        }

        startGame();
    }

    private Color getColor(int index) {
        return switch (index) {
            case 0 -> Color.RED.darker();
            case 1 -> Color.GREEN.darker();
            case 2 -> Color.BLUE.darker();
            case 3 -> Color.YELLOW.darker();
            default -> Color.BLACK;
        };
    }

    public void   startGame() {
        sequence.clear();
        currentStep = 0;
        addNewStep();
        playSequence();
    }

    private void addNewStep() {
        sequence.add(random.nextInt(4));
        tamanhoa++;
        System.out.println("tamanho aumentou");
        System.out.println("valor tamanho pos somado:"+tamanhoa);
    }

    private void playSequence() {
        userTurn = false;
        currentStep = 0;
         int tamanho;
         tamanho =sequence.size();
         for(int i =0;i<tamanho;i++)
                 {
                     System.out.println("Lista posicao ["+i+"] = "+sequence.get(i));
                 }
        // Exibir a sequência com um atraso entre os destaques
        Timer sequenceTimer = new Timer(300, new ActionListener() {
            private int sequenceIndex = 0; // Índice para rastrear a sequência mostrada
            private boolean highlighting = false; // Controle para exibir o botão

            @Override
            public void actionPerformed(ActionEvent e) {
                if (sequenceIndex < sequence.size()) {
                    if (!highlighting) {
                        highlightButton(sequence.get(sequenceIndex));
                        highlighting = true;
                    } else {
                        resetButtonColor(sequence.get(sequenceIndex));
                        sequenceIndex++;
                        highlighting = false;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                    userTurn = true;
                    currentStep = 0; // Reseta currentStep para controle do usuário
                }
            }
        });

        sequenceTimer.setInitialDelay(0); // Inicia imediatamente
        sequenceTimer.start();
    }

    private void highlightButton(int index) {
        JButton button = buttons[index];
        button.setBackground(button.getBackground().brighter());
    }

    private void resetButtonColor(int index) {
        JButton button = buttons[index];
        button.setBackground(getColor(index)); // Volta para a cor original
    }

    private class ButtonClickListener implements ActionListener {
        private int index;

        public ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (userTurn) {
                if (sequence.get(currentStep) == index) {
                    currentStep++;
                    if (currentStep == sequence.size()) {
                        addNewStep();
                        playSequence();
                    }
                } else {
                    JOptionPane.showMessageDialog(Game.this, "Game Over!");
                    fimdejogo(true);
                    
                   
                }
            }
        }
    }
    public boolean fimdejogo(boolean a)
    {
       return(  teste.finalizado());
    }
    public int pontuacao()
    {
        System.out.println("currentStep"+ currentStep);
        System.out.println("sequencesize"+  sequence.size());
        
            System.out.println("valor tamanho"+tamanhoa);
        
        int pontuacao= tamanhoa*100;
        tamanhoa =0;
        return(pontuacao);
    }
    public static  Game rodar(Competicao a ) {
      
            
            Game game = new Game(a);
            game.setVisible(true);
            
       
        return game;
    }
    
}
