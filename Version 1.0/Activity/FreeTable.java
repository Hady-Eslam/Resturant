package resturant.Activity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import resturant.Menu;

public class FreeTable extends JFrame{
    
    JPanel PTitle,PID,PDelete,PBack;
    JLabel Title,Text;
    JTextField ID;
    JButton Delete,Back;
    Box Small,Big;
    
    int Orders;
    int []Tables=new int[50];
    
    public FreeTable(int Orders,int[]Tables){
        
        for (int i=0;i<50;i++)
            this.Tables[i]=Tables[i];
        
        this.Orders=Orders;
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToFrame();
    }

    private void SetFrameAndPanels() {
    
        this.setTitle("Resturant");
        this.setSize(300,300);
        this.setResizable(false);
        this.setLocation(450,230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        PTitle=new JPanel();
        //PTitle.setBackground(Color.red);
        
        PID=new JPanel();
        //PID.setBackground(Color.BLUE);
        
        PDelete=new JPanel();
        //PDelete.setBackground(Color.CYAN);
        
        Small=Box.createVerticalBox();
        Small.setBorder(new EmptyBorder(5,5,5,5));
        
        PBack=new JPanel();
        //PBack.setBackground(Color.GREEN);
        
        Big=Box.createVerticalBox();
        Big.setBorder(new EmptyBorder(5,5,5,5));
    }

    private void SetComponents() {
    
        Title=new JLabel();
        Title.setText("Free Table");
        
        Text=new JLabel();
        Text.setText("Table Number");
        
        ID=new JTextField();
        ID.setColumns(15);
        ID.setBorder(new EmptyBorder(3,3,3,3));
        
        Delete=new JButton();
        Delete.setText("Free Table");
        Delete.addActionListener(new DeleteAction());
        
        Back=new JButton();
        Back.setText("Back");
        Back.addActionListener(new BackAction());
    }

    private void AddComponentsToFrame() {
    
        PTitle.add(Title);
        
        PID.add(Text);
        PID.add(ID);
        
        PDelete.add(Delete);
        
        Small.add(PID);
        Small.add(Box.createVerticalStrut(5));
        Small.add(PDelete);
        
        PBack.add(Back);
        
        Big.add(PTitle);
        Big.add(Small);
        Big.add(PBack);
        
        this.add(Big,BorderLayout.CENTER);
    }
    
    
    
    private class DeleteAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            int X=GetTable(ID.getText());
            
            try{
                File file=new File("E:\\My Projects\\Resturant\\Tables\\_"+ID.getText()+".txt");
                if (!file.exists())
                    JOptionPane.showMessageDialog(null,"There Is No Sush Order");
                else{
                    file.delete();
                    
                    Tables[X-1]=X;
                    JOptionPane.showMessageDialog(null,"Done");
                    ID.setText("");
                    /*Scanner output=new Scanner(file);
                    
                    while(output.hasNext()){
                        String X=output.nextLine();
                    }*/
                }
            }
            catch(Exception E){
                JOptionPane.showMessageDialog(null,"Wrong In Opening File");
                System.exit(0);
            }
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
        
            FreeTable.this.dispose();
            new Menu(Orders,Tables);
        }
    }
}
