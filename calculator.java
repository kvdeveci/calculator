
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calucalator implements ActionListener {

    JFrame frame;
    JTextField textfield;

    JButton[] numberButton = new JButton[10];
    JButton[] functiButtons = new JButton[9];

    JButton addButton, sumButton, mulButton, divButton;
    JButton decimalButton, equalsButton, delButton, clrButton,negativeButton;

    JPanel panel;

    Font myfont = new Font("SansSerif", Font.BOLD, 30);

    double num1 = 0;
    double num2 = 0;
    double resoult = 0;

    char operator;
    
    Calucalator(){
        
        frame = new JFrame( "Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        
        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);
        
        addButton = new JButton("+");
        sumButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negativeButton = new JButton("(-)");
        
        functiButtons[0] = addButton;
        functiButtons[1] = sumButton;
        functiButtons[2] = mulButton;
        functiButtons[3] = divButton;
        
        functiButtons[4] = decimalButton;
        functiButtons[5] = equalsButton;
        functiButtons[6] = delButton;
        functiButtons[7] = clrButton;
        functiButtons[8] = negativeButton;
        
        for (int i = 0; i < 9; i++) {
            
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(myfont);
            functiButtons[i].setFocusable(false);
            
        }
        
        for (int i = 0; i < 10; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(true);
        }
        
        negativeButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250, 430, 100,50);
        
        panel = new  JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
              
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(sumButton);
        
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        
        panel.add(decimalButton);
        panel.add(divButton);
        panel.add(numberButton[0]); 
        panel.add(decimalButton);
        panel.add(equalsButton);
       
        
        frame.add(panel);
        frame.add(negativeButton );
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
         Calucalator cal = new Calucalator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 10; i++) {
            
            if (e.getSource() == numberButton[i]) {
                
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                
            }
            
        }
        
        if (e.getSource() == decimalButton) {
            
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
            
        }
        if (e.getSource() == addButton) {
            
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");          
        }
        
          if (e.getSource() == sumButton) {
            
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");          
        }
          
          if (e.getSource() == mulButton) {
            
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");          
        }
          
          if (e.getSource() == divButton) {
            
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");          
        }
          
        if (e.getSource() == equalsButton) {
            
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator){
                
                case'+':
                    resoult = num1+num2;
                    break;
                    
                case '-':
                    resoult = num1-num2;                   
                    break;
                
                case '*':
                    resoult = num1*num2;
                    break;
                
                case '/':
                    resoult = num1/num2;
                    break;
                    
  
            }
                textfield.setText(String.valueOf(resoult));
                num1 = resoult;
        }
        
        if (e.getSource() == clrButton) {
            textfield.setText("");
            
        }
        if (e.getSource() == delButton) {
            
            String string = textfield.getText();
            textfield.setText("");
            
            for (int i = 0; i < string.length()-1 ; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
            
            
        }
        if (e.getSource() == negativeButton) {
            
            double temp  = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
            
            
            
        }
    }
}
