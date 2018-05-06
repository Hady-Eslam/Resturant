package resturant.Record;

import java.util.ArrayList;

public class Order {
    
    private int ID=0,Table=0;
    private String Name="",Date="";
    private ArrayList<Food> food=new ArrayList<Food>();
    
    public Order(int ID,String Name,String Date,int Table){
        
        this.ID=ID;
        this.Name=Name;
        this.Date=Date;
        this.Table=Table;
    }
    
    public int GetID(){
        return ID;
    }
    public String GetName(){
        return Name;
    }
    public String GetDate(){
        return Date;
    }
    public int GetTable(){
        return Table;
    }
    public ArrayList<Food> GetFood(){
        return food;
    }
    
    
    public void SetFood(Food food){
        this.food.add(food);
    }
}
