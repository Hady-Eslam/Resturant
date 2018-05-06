package resturant.Activity;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import resturant.Menu;
import resturant.Record.Order;

public class ReserveTable extends JFrame{
    
    JPanel PTitle,PID,PName,PDate,PTable,PSet,PBack;
    JLabel Title,ID,TName,TDate,Table;
    JTextField Name,Date;
    JComboBox JTable;
    JButton Set,Back;
    Box Small,Big;
    
    int Orders;
    private int[]Tables=new int[50];
    
    public ReserveTable(int Orders,int []Tables){
        
        for (int i=0;i<50;i++)
            this.Tables[i]=Tables[i];
        
        this.Orders=Orders;
        
        SetFrameAndPanels();
        SetComponents();
        SetTable();
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
        //PTitle.setBackground(Color.red);
        
        PID=new JPanel();
        //PID.setBackground(Color.BLUE);
        PID.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PName=new JPanel();
        //PName.setBackground(Color.GREEN);
        PName.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PDate=new JPanel();
        //PDate.setBackground(Color.MAGENTA);
        PDate.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PTable=new JPanel();
        PTable.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PSet=new JPanel();
        //PSet.setBackground(Color.ORANGE);
        
        Small=Box.createVerticalBox();
        Small.setBorder(new EmptyBorder(5,5,5,5));
        
        PBack=new JPanel();
        //PBack.setBackground(Color.YELLOW);
        
        Big=Box.createVerticalBox();
        Big.setBorder(new EmptyBorder(5,5,5,5));
    }

    private void SetComponents() {
    
        Title=new JLabel();
        Title.setText("Add Table");
        
        ID=new JLabel();
        ID.setText("Order Number ==>>   "+Orders);
        
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
        
        Table=new JLabel();
        Table.setText("Table Number ==>>");
        
        JTable=new JComboBox();
        JTable.setMaximumRowCount(4);
        
        Set=new JButton();
        Set.setText("Set Food");
        Set.addActionListener(new SetFood());
        
        Back=new JButton();
        Back.setText("Back To Menu");
        Back.addActionListener(new BackAction());
    }
    
    private void SetTable(){
        
        for (int i=0;i<10;i++)
            if (Tables[i]!=0)
                JTable.addItem( Integer.toString(Tables[i]) );
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
        
        PTable.add(Table);
        PTable.add(Box.createHorizontalStrut(15));
        PTable.add(JTable);
        
        PSet.add(Set);
        
        Small.add(PID);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PName);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PDate);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PTable);
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
        
            int X=GetTable(JTable.getSelectedItem().toString());
            if (Name.getText().length()!=0&&Date.getText().length()!=0){
                ReserveTable.this.dispose();
                Tables[X-1]=0;
                new SetFoods( new Order(Orders,Name.getText(),Date.getText(),X)
                                ,2,Orders,Tables);
            }
            else 
                JOptionPane.showMessageDialog(null,"Enter Full Info");
        }
        private int GetTable(String to){
            
            int x=0;
            for (int i=0;i<to.length();i++){
                x*=10;
                x+=(int)to.charAt(i)-48;
            }
            return x;
        }
    }
    
    private class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            ReserveTable.this.dispose();
            new Menu(Orders,Tables);
        }
    }
}
