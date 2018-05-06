package resturant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class Begining extends JFrame{

    private JPanel PLogIn,PName,PPassword,PTitle;
    private JLabel Title,TName,TPassword;
    private JTextField Name,Password;
    private JButton LogIn;
    private Box box,Big_Box;
    
    private int Orders=0;
    private int Tables[]=new int[50];
    
    public Begining(int Orders,int[]Tables){
    
        for (int i=0;i<50;i++)
            this.Tables[i]=Tables[i];
        
        this.Orders=Orders;
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToFrame();
    }
    
    public void SetFrameAndPanels(){
    
        this.setTitle("Resturant");
        this.setSize(300,300);
        this.setResizable(false);
        this.setLocation(480,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        PTitle=new JPanel();
        //PTitle.setBackground(Color.red);
        
        PName=new JPanel();
        //PName.setBackground(Color.BLUE);
        PName.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PPassword=new JPanel();
        //PPassword.setBackground(Color.GREEN);
        PPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        PLogIn=new JPanel();
        
        box=Box.createVerticalBox();
        box.setBorder(new EmptyBorder(5,5,5,5));
        
        Big_Box=Box.createVerticalBox();
        Big_Box.setBorder(new EmptyBorder(5,5,5,5));
    }
    
    public void SetComponents(){
        
        Title=new JLabel();
        Title.setText("Log In");
        
        Name=new JTextField();
        Name.setColumns(15);
        Name.setBorder(new EmptyBorder(3,3,3,3));
        
        TName=new JLabel();
        TName.setText("Handel ");
        
        Password=new JTextField();
        Password.setColumns(15);
        Password.setBorder(new EmptyBorder(3,3,3,3));
        
        TPassword=new JLabel();
        TPassword.setText("Password ");
        
        LogIn=new JButton();
        LogIn.setText("Log In");
        LogIn.addActionListener(new LogInAction());
    }
    
    public void AddComponentsToFrame(){
    
        PTitle.add(Title);
        
        PName.add(TName);
        PName.add(Box.createHorizontalStrut(14));
        PName.add(Name);
        
        PPassword.add(TPassword);
        PPassword.add(Password);
        
        PLogIn.add(LogIn);
        
        box.add(PName);
        box.add(Box.createVerticalStrut(5));
        box.add(PPassword);
        box.add(Box.createVerticalStrut(5));
        box.add(PLogIn);
        
        Big_Box.add(PTitle);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(box);
        
        this.add( Big_Box,BorderLayout.CENTER );
    }

    
    
    class LogInAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
            if (Name.getText().equals("Hady")&&Password.getText().equals("0")){
                Begining.this.dispose();
                new Menu(Orders,Tables);
            }
            else
                JOptionPane.showMessageDialog(null,"Wrong Handel Or Password");
        }
    }
    
    public static void main(String[] args) {
       
        EventQueue.invokeLater( new Runnable(){

            @Override
            public void run() {
            
                int []Tables=new int[50];
                for (int i=0;i<50;i++)
                    Tables[i]=i+1;
                new Begining(101,Tables);
            }
        });
    }
}
