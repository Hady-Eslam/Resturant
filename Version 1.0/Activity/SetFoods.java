package resturant.Activity;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import resturant.Record.Food;
import resturant.Record.Order;

public class SetFoods extends JFrame{
    
    private JPanel PFood,PAddFood,PTFood,
                    PDrink,PAddDrink,PTDrink,
                    PDesert,PAddDesert,PTDesert,
                    PTitle,PSubmit,PBack;
    private JComboBox Desert,Food,Drink;
    private JTextArea TFood,TDrink,TDesert;
    private JButton Submit,AddDesert,AddFood,AddDrink,Back;
    private JLabel Title;
    private Box BFood,BDrink,BDesert,Small_Box,box,Big_Box;
    
    private Order order;
    private int Frame,Orders;
    
    private ArrayList<Food> food=new ArrayList<Food>();
    private int []Tables=new int[50];
    
    public SetFoods(Order order,int Frame,int Orders,int []Tables){
        
        for (int i=0;i<50;i++)
            this.Tables[i]=Tables[i];
        
        this.order=order;
        this.Frame=Frame;
        this.Orders=Orders;
        
        SetFrameAndPanels();
        SetComponents();
        AddComponentsToFrame();
    }
    
    private void SetFrameAndPanels() {
    
        this.setTitle("Resturant And Hotel");
        this.setSize(600,600);
        this.setResizable(false);
        this.setLocation(350,110);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        
        PTitle=new JPanel();
        
        PFood=new JPanel();        
        PAddFood=new JPanel();
        PTFood=new JPanel();
        BFood=Box.createVerticalBox();
        
        PDrink=new JPanel();
        PAddDrink=new JPanel();
        PTDrink=new JPanel();
        BDrink=Box.createVerticalBox();
        
        PDesert=new JPanel();
        PAddDesert=new JPanel();
        PTDesert=new JPanel();
        BDesert=Box.createVerticalBox();
        
        Small_Box=Box.createHorizontalBox();
        Small_Box.setBorder(new EmptyBorder(5,5,5,5));
        
        PSubmit=new JPanel();
        
        box=Box.createVerticalBox();
        box.setBorder(new EmptyBorder(5,5,5,5));
        
        PBack=new JPanel();
        
        Big_Box=Box.createVerticalBox();
        Big_Box.setBorder(new EmptyBorder(5,5,5,5));
    }

    private void SetComponents() {
    
        Title=new JLabel();
        Title.setText("Book Food");
        
        Food=new JComboBox();
        Food.setMaximumRowCount(10);
        
        AddFood=new JButton();
        AddFood.setText("Add Food");
        AddFood.addActionListener(new AddFoodAction());
        
        TFood=new JTextArea();
        TFood.setColumns(15);
        TFood.setRows(13);
        TFood.setBorder(new EmptyBorder(3,3,3,3));
        TFood.setLineWrap(true);
        
        Drink=new JComboBox();
        Drink.setMaximumRowCount(10);
        
        AddDrink=new JButton();
        AddDrink.setText("Add Drinks");
        AddDrink.addActionListener(new AddDrinkAction());
        
        TDrink=new JTextArea();
        TDrink.setColumns(15);
        TDrink.setRows(13);
        TDrink.setBorder(new EmptyBorder(3,3,3,3));
        TDrink.setLineWrap(true);
        
        Desert=new JComboBox();
        Desert.setMaximumRowCount(10);
        
        AddDesert=new JButton();
        AddDesert.setText("Add Desert");
        AddDesert.addActionListener(new AddDesertAction());
        
        TDesert=new JTextArea();
        TDesert.setColumns(15);
        TDesert.setRows(13);
        TDesert.setBorder(new EmptyBorder(3,3,3,3));
        TDesert.setLineWrap(true);
        
        Submit=new JButton();
        Submit.setText("Submit");
        Submit.addActionListener(new SubmitAction());
        
        Back=new JButton();
        Back.setText("Back");
        Back.addActionListener(new BackAction());
        
        SetF_D_D();
    }
    
    private void SetF_D_D(){
        
        Food.addItem(new Food("Checken",20,1,0));
        Food.addItem(new Food("Meet",25,1,0));
        Food.addItem(new Food("Rice",5,1,0));
        Food.addItem(new Food("Salade",3,1,0));
        Food.addItem(new Food("KoShary",7,1,0));
        Food.addItem(new Food("Pasta",7,1,0));
        Food.addItem(new Food("Grilled Fish",20,1,0));
        Food.addItem(new Food("Fried Fish",20,1,0));
        Food.addItem(new Food("Soup",5,1,0));
        Food.addItem(new Food("Botatos",10,1,0));
        Food.addItem(new Food("Vegetables",10,1,0));
        
        Drink.addItem(new Food("Cola",10,2,0));
        Drink.addItem(new Food("Sprite",10,2,0));
        Drink.addItem(new Food("Fanta",10,2,0));
        Drink.addItem(new Food("SChewps",10,2,0));
        Drink.addItem(new Food("Milk",5,2,0));
        Drink.addItem(new Food("Cofee",7,2,0));
        Drink.addItem(new Food("Unsone",5,2,0));
        Drink.addItem(new Food("Qerfa",5,2,0));
        Drink.addItem(new Food("Cpsbra",5,2,0));
        
        Desert.addItem(new Food("Mahalabya",5,3,0));
        Desert.addItem(new Food("Jely",5,3,0));
        Desert.addItem(new Food("Milk+Rice",5,3,0));
        Desert.addItem(new Food("Basbosa",5,3,0));
        Desert.addItem(new Food("PieceOfCake",5,3,0));
        Desert.addItem(new Food("Golash",5,3,0));
    }
    
    private void AddComponentsToFrame() {
    
        PTitle.add(Title);
        
        PFood.add(Food);
        PAddFood.add(AddFood);
        PTFood.add(TFood);
        
        BFood.add(PFood);
        BFood.add(Box.createVerticalStrut(5));
        BFood.add(PAddFood);
        BFood.add(Box.createVerticalStrut(5));
        BFood.add(PTFood);
        
        PDrink.add(Drink);
        PAddDrink.add(AddDrink);
        PTDrink.add(TDrink);
        
        BDrink.add(PDrink);
        BDrink.add(Box.createVerticalStrut(5));
        BDrink.add(PAddDrink);
        BDrink.add(Box.createVerticalStrut(5));
        BDrink.add(PTDrink);
        
        PDesert.add(Desert);
        PAddDesert.add(AddDesert);
        PTDesert.add(TDesert);
        
        BDesert.add(PDesert);
        BDesert.add(Box.createVerticalStrut(5));
        BDesert.add(PAddDesert);
        BDesert.add(Box.createVerticalStrut(5));
        BDesert.add(PTDesert);
        
        Small_Box.add(BFood);
        Small_Box.add(Box.createHorizontalStrut(5));
        Small_Box.add(BDrink);
        Small_Box.add(Box.createHorizontalStrut(5));
        Small_Box.add(BDesert);
        
        PSubmit.add(Submit);
        
        box.add(Small_Box);
        box.add(Box.createVerticalStrut(5));
        box.add(PSubmit);
        
        PBack.add(Back);
        
        Big_Box.add(PTitle);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(box);
        Big_Box.add(Box.createVerticalStrut(5));
        Big_Box.add(PBack);
        
        this.add(Big_Box,BorderLayout.CENTER);
    }
    
    
    
    
    
    
    
    private class AddFoodAction implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent e) {
        
            SetData();
            SetData1();
        }
        private void SetData1() {

            TFood.setText("");
            for (int i=0;i<food.size();i++)
                if (food.get(i).GetTybe()==1){
                    TFood.setText( TFood.getText()+Integer.toString(food.get(i).GetCount()) +
                                   food.get(i).GetName() + "\n");
                }
        }
        private void SetData(){

            Food Dish=(Food) Food.getSelectedItem();
            boolean NO=false;

            for (int i=0;i<food.size();i++){
                if (food.get(i).GetTybe()==Dish.GetTybe())
                    if (food.get(i).GetName().equals(Dish.GetName())){
                        food.get(i).SetCount();
                        NO=true;
                    }
                if (NO==true)
                    break;
            }
            if (NO==false){

                Dish.SetCount();
                food.add(Dish);
            }
        }
        
    }
    
    private class AddDrinkAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            SetData();
            SetData1();
        }
        private void SetData1() {

            TDrink.setText("");
            for (int i=0;i<food.size();i++)
                if (food.get(i).GetTybe()==2){
                    TDrink.setText( TDrink.getText()+Integer.toString(food.get(i).GetCount()) +
                                   food.get(i).GetName() + "\n");
                }
        }
        private void SetData(){

            Food Dish=(Food) Drink.getSelectedItem();
            boolean NO=false;

            for (int i=0;i<food.size();i++){
                if (food.get(i).GetTybe()==Dish.GetTybe())
                    if (food.get(i).GetName().equals(Dish.GetName())){
                        food.get(i).SetCount();
                        NO=true;
                    }
                if (NO==true)
                    break;
            }
            if (NO==false){

                Dish.SetCount();
                food.add(Dish);
            }
        }
    }
    
    private class AddDesertAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            SetData();
            SetData1();
        }
        private void SetData1() {

            TDesert.setText("");
            for (int i=0;i<food.size();i++)
                if (food.get(i).GetTybe()==3){
                    TDesert.setText( TDesert.getText()+Integer.toString(food.get(i).GetCount()) +
                                   food.get(i).GetName() + "\n");
                }
        }
        private void SetData(){

            Food Dish=(Food) Desert.getSelectedItem();
            boolean NO=false;

            for (int i=0;i<food.size();i++){
                if (food.get(i).GetTybe()==Dish.GetTybe())
                    if (food.get(i).GetName().equals(Dish.GetName())){
                        food.get(i).SetCount();
                        NO=true;
                    }
                if (NO==true)
                    break;
            }
            if (NO==false){

                Dish.SetCount();
                food.add(Dish);
            }
        }
    }
    
    private class SubmitAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            String X="";
            if (order.GetTable()==0)
                X="E:\\My Projects\\Resturant\\Orders\\"+order.GetID()+".txt";
            else
                X="E:\\My Projects\\Resturant\\Tables\\_"+order.GetTable()+".txt";
            
            
            try{
                File file=new File(X);
                if (!file.exists())
                    file.createNewFile();
                
                PrintWriter input=new PrintWriter(file);
                input.println("1"+order.GetName());
                input.println("2"+order.GetDate());
                for (int i=0;i<food.size();i++)
                    input.println(food.get(i).GetCount()+" "+
                                    food.get(i).GetName()+" "+
                                    food.get(i).GetPrice());
                input.close();
            }
            catch(Exception E){
                JOptionPane.showMessageDialog(null,"Wrong In Opening File");
                System.exit(0);
            }
            SetFoods.this.dispose();
            Orders++;
            if (Frame==1)
                new AddOrder(Orders,Tables);
            else
                new ReserveTable(Orders,Tables);
        }        
    }
    
    private class BackAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        
            SetFoods.this.dispose();
            new AddOrder(Orders,Tables);
        }
    }
}