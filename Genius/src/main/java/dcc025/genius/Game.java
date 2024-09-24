package dcc025.genius;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JFrame {
    private ArrayList<Integer> sequence;
    private int currentStep;
    private JButton[] buttons;
    private Random random;
    private boolean userTurn;

    public Game() {
        sequence = new ArrayList<>();
        currentStep = 0;
        random = new Random();
        userTurn = false;

        // Configuração da interface
        setTitle("Genius Game");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        switch (index) {
            case 0: return Color.RED.darker();
            case 1: return Color.GREEN.darker();
            case 2: return Color.BLUE.darker();
            case 3: return Color.YELLOW.darker();
            default: return Color.BLACK;
        }
    }

    private void startGame() {
        sequence.clear();
        currentStep = 0;
        addNewStep();
        playSequence();
    }

    private void addNewStep() {
        sequence.add(random.nextInt(4));
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
        Timer sequenceTimer = new Timer(1000, new ActionListener() {
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
                    startGame();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}
