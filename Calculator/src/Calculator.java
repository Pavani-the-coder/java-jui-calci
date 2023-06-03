/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavani
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame f;
    JTextField tf1;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons= new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton,negButton;
    JPanel panel;
    Font myFont =new Font("Ink free ",Font.BOLD,30);
    double num1=0,num2=0,res=0;
    char operator;
    
    Calculator(){
        f=new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420,550);
        f.setLayout(null);
        
        tf1=new JTextField();
        tf1.setBounds(50,25,300,50);
        tf1.setFont(myFont);
        tf1.setEditable(false);
        f.setResizable(false);
        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Del");
        clrButton=new JButton("clr");
        negButton=new JButton("neg");
        //functi0nButtons[]={addButton,}
        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton (String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
         negButton.setBounds(50,430,90,50);
        delButton.setBounds(150,430,90,50);
        clrButton.setBounds(250,430,90,50);
       
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
                
        f.add(panel);
        f.add(negButton);
        f.add(delButton);
        f.add(clrButton);
        f.add(tf1);
        f.setVisible(true);
        
    }
    public static void main(String [] args){
        Calculator c= new Calculator();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
           if(e.getSource()==numberButtons[i]){
               tf1.setText(tf1.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource()==decButton){
               tf1.setText(tf1.getText().concat("."));
               
           }
       if(e.getSource()==addButton){
               num1=Double.parseDouble(tf1.getText());
               operator='+';
               tf1.setText(" ");
               
           }
       if(e.getSource()==subButton){
               num1=Double.parseDouble(tf1.getText());
               operator='-';
               tf1.setText(" ");
               
           }
       if(e.getSource()==mulButton){
               num1=Double.parseDouble(tf1.getText());
               operator='*';
               tf1.setText(" ");
               
           }
       
        if(e.getSource()==divButton){
               num1=Double.parseDouble(tf1.getText());
               operator='/';
               tf1.setText(" ");
               
           }
       
         if(e.getSource()==equButton){
               num2=Double.parseDouble(tf1.getText());
               switch(operator){
                   case '+':
                       res=num1+num2;
                       break;
                    case '-':
                       res=num1-num2;
                       break;
                    case '*':
                       res=num1*num2;
                       break;
                    case '/':
                       res=num1/num2;
                      // Math.round(res);
                       break;
               }
               tf1.setText(String.valueOf(res));
               num1=res;
               
           }if(e.getSource()==clrButton){
                   tf1.setText("");
               }
               if(e.getSource()==delButton){
                   String str=tf1.getText();
                   tf1.setText("");
                   for(int i=0;i<str.length()-1;i++){
                       tf1.setText(tf1.getText()+str.charAt(i));
                   }
               
           }
         if(e.getSource()==negButton) {
			double temp = Double.parseDouble(tf1.getText());
			temp*=-1;
			tf1.setText(String.valueOf(temp));
		}
    }

}
