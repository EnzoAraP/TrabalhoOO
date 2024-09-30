package dcc025.genius.Telas;

import dcc025.genius.CompeticaoeCampeonato.Competicao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Game  {
    private ArrayList<Integer> sequence;
    private int currentStep;
    private JButton[] buttons;
    private Random random;
    private boolean userTurn;
    Competicao teste;
    int tamanhoa=0;
    int dificuldade;
    private JFrame tela;
    private TelaDificuldade tldificuldade;

    public Game(Competicao a,int dificuldade, TelaDificuldade tldificuldade) {
        teste=a;
        sequence = new ArrayList<>();
        currentStep = 0;
        random = new Random();
        userTurn = false;
        this.dificuldade=dificuldade;
        this.tldificuldade=tldificuldade;
        tela= new JFrame();
        // Configuração da interface
        tela.setTitle("Genius Game");
        tela.setSize(600, 600);
        tela.addWindowListener(new Game.ControleJanela());
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLayout(new GridLayout(2, 2));

        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(getColor(i));
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            buttons[i].addActionListener(new ButtonClickListener(i));
            tela.add(buttons[i]);
        }

        
    }
    public JFrame getFrame(){
        return tela;
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
    private int dificulade( int a)
    {
        return switch(a)
        {
            
            case 1-> 700;
            case 2-> 500;
            case 3-> 400;
            case 4-> 200;
            default ->500;
        } ;   
        
            
    }
    private void playSequence() {
        teste.atualizaPontuacao();
        userTurn = false;
        currentStep = 0;
         int tamanho;
         tamanho =sequence.size();
         for(int i =0;i<tamanho;i++)
                 {
                     System.out.println("Lista posicao ["+i+"] = "+sequence.get(i));
                 }
        // Exibir a sequência com um atraso entre os destaques
        Timer sequenceTimer = new Timer(dificulade(dificuldade), new ActionListener() {
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
                    JOptionPane.showMessageDialog(tela, "Game Over!");
                    fimdejogo(true);
                    
                   
                }
            }
        }
    }
    public JFrame getTela()
    {
        return tela;
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
        
        int pontuacao= (tamanhoa-1);
        tamanhoa =0;
        return(pontuacao);
    }
     private class ControleJanela implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
         
        }

        @Override
        public void windowClosing(WindowEvent e) {
           if(tldificuldade!=null)
         tldificuldade.mostrar(true);
        }
        @Override
        public void windowClosed(WindowEvent e) {
         
        }

        @Override
        public void windowIconified(WindowEvent e) {
            
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        
        }

        @Override
        public void windowActivated(WindowEvent e) {
          
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            
        }
        
    }
    public static  Game rodar(Competicao a, int dificilade,TelaDificuldade tldificuldade ) {
      
            
            Game game = new Game(a, dificilade, tldificuldade );
            game.tela.setVisible(true);
            
       
        return game;
    }
    
}
