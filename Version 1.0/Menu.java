package resturant;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import resturant.Activity.AddOrder;
import resturant.Activity.FreeTable;
import resturant.Activity.RemoveOrder;
import resturant.Activity.ReserveTable;

public class Menu extends JFrame{
    
    private JPanel PAdd,PRemove,PReserve,PRemoveReserved,PTitle,PBack;
    private JLabel Title;
    private JButton AddRecord,RemoveRecord,Reserve,RemoveReserved,Back;
    private Box box,Big_Box;
    
    private int Orders=0;
    private int []Tables=new int[50];
    
    public Menu(int Orders,int []Tables){
        
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
        
        PAdd=new JPanel();
        
        PRemove=new JPanel();
        
        PReserve=new JPanel();
        
        PRemoveReserved=new JPanel();
        
        box=Box.createVerticalBox();
        box.setBorder(new EmptyBorder(5,5,5,5));
        
        PBack=new JPanel();
        
        Big_Box=Box.createVerticalBox();
        Big_Box.setBorder(new EmptyBorder(5,5,5,5));
    }

    private void SetComponents() {
    
        Title=new JLabel();
        Title.setText("Menu");
        
        AddRecord=new JButton();
        AddRecord.setText("Add Order");
        AddRecord.addActionListener(new AddOrderAction());
        
        RemoveRecord=new JButton();
        RemoveRecord.setText("Remove Order");
        RemoveRecord.addActionListener(new RemoveOrderAction());
        
        Reserve=new JButton();
        Reserve.setText("Reserve Table");
        Reserve.addActionListener(new ReserveTableAction());
        
        RemoveReserved=new JButton();
        RemoveReserved.setText("Remove Reserved Table");
        RemoveReserved.addActionListener(new FreeTableAction());
        
        Back=new JButton();
        Back.setText("Back");
        Back.addActionListener(new BackAction());
    }

    private void AddComponentsToFrame() {
    
        PTitle.add(Title);
        
        PAdd.add(AddRecord);
        
        PRemove.add(RemoveRecord);
        
        PReserve.add(Reserve);
        
        PRemoveReserved.add(RemoveReserved);
        
        box.add(PAdd);
        box.add(Box.createVerticalStrut(5));
        box.add(PRemove);
        box.add(Box.createVerticalStrut(5));
        box.add(PReserve);
        box.add(Box.createVerticalStrut(5));
        box.add(PRemoveReserved);
        
        PBack.add(Back);
        
        Big_Box.add(PTitle);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(box);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(PBack);
        
        this.add(Big_Box,BorderLayout.CENTER);
    }
    
    
    
    
    private class AddOrderAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
           Menu.this.dispose();
           new AddOrder(Orders,Tables);
        }
    }
    
    private class RemoveOrderAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            Menu.this.dispose();
            new RemoveOrder(Orders,Tables);
        }
    }
    
    private class ReserveTableAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
           Menu.this.dispose();
           new ReserveTable(Orders,Tables);
        }
    }
    
    private class FreeTableAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
           Menu.this.dispose();
           new FreeTable(Orders,Tables);
        }
    }
    
    private class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            Menu.this.dispose();
            new Begining(Orders,Tables);
        }
    }
}
