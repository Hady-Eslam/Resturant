package resturant.Activity;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import resturant.Record.Order;

public class Print extends JFrame{
    
    JLabel Title,Show;
    JPanel PTitle,PBack,PShow;
    JButton Back;
    Box box;
    public Print(Order order,String File){
     
        this.setTitle("Resturant");
        this.setSize(400,400);
        this.setResizable(false);
        this.setLocation(450,230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        PTitle=new JPanel();
        Title=new JLabel();
        Title.setText("Print Bill");
        PTitle.add(Title);
        
        PShow=new JPanel();
        Show=new JLabel();
        PShow.add(Show);
        
        PBack=new JPanel();
        Back=new JButton();
        PBack.add(Back);
        
        box=Box.createVerticalBox();
        box.add(PTitle);
        box.add(PShow);
        box.add(PBack);
        
        this.add(box,BorderLayout.CENTER);
    }
    
    class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            Print.this.dispose();
        }
    }
}
