package resturant.Activity;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import resturant.Menu;
import resturant.Record.Order;

public class AddOrder extends JFrame{
    
    JPanel PTitle,PID,PName,PDate,PSet,PBack;
    JLabel Title,ID,TName,TDate;
    JTextField Name,Date;
    JButton Set,Back;
    Box Small,Big;
    
    private int Orders=0;
    private int Tables[]=new int[50];
    
    public AddOrder(int Orders,int []Tables){
        
        for (int i=0;i<50;i++)
            this.Tables[i]=Tables[i];
        
        this.Orders=Orders;
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToFrame();
    }

    private void SetFrameAndPanels() {
    
        this.setTitle("Resturant");
        this.setSize(400,400);
        this.setResizable(false);
        this.setLocation(450,230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        PTitle=new JPanel();
        
        PID=new JPanel();
        PID.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PName=new JPanel();
        PName.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PDate=new JPanel();
        PDate.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PSet=new JPanel();
        
        Small=Box.createVerticalBox();
        Small.setBorder(new EmptyBorder(5,5,5,5));
        
        PBack=new JPanel();
        
        Big=Box.createVerticalBox();
        Big.setBorder(new EmptyBorder(5,5,5,5));
    }

    private void SetComponents() {
    
        Title=new JLabel();
        Title.setText("Add Order");
        
        ID=new JLabel();
        ID.setText("Order Number ==>>       "+Orders);
        
        TName=new JLabel();
        TName.setText("Customer Name ==>>");
        
        Name=new JTextField();
        Name.setColumns(15);
        Name.setBorder(new EmptyBorder(3,3,3,3));
        
        TDate=new JLabel();
        TDate.setText("Date Of Order ===>>");
        
        Date=new JTextField();
        Date.setColumns(10);
        Date.setBorder(new EmptyBorder(3,3,3,3));
        
        Set=new JButton();
        Set.setText("Set Food");
        Set.addActionListener(new SetFood());
        
        Back=new JButton();
        Back.setText("Back To Menu");
        Back.addActionListener(new BackAction());
    }

    private void AddComponentsToFrame() {
    
        PTitle.add(Title);
        
        PID.add(ID);
        
        PName.add(TName);
        PName.add(Box.createHorizontalStrut(3));
        PName.add(Name);
        
        PDate.add(TDate);
        PDate.add(Box.createHorizontalStrut(10));
        PDate.add(Date);
        
        PSet.add(Set);
        
        Small.add(PID);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PName);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PDate);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PSet);
        
        PBack.add(Back);
        
        Big.add(PTitle);
        Big.add(Small);
        Big.add(PBack);
        
        this.add(Big,BorderLayout.CENTER);
    }
    
    
    private class SetFood implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            if (Name.getText().length()!=0&&Date.getText().length()!=0){
                AddOrder.this.dispose();
                new SetFoods( new Order(Orders,Name.getText(),Date.getText(),0),1,Orders,Tables);
            }
            else 
                JOptionPane.showMessageDialog(null,"Enter Full Info");
        }
    }
    
    private class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            AddOrder.this.dispose();
            new Menu(Orders,Tables);
        }
    }
}
