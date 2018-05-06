package resturant.Record;

public class Food {
    
    private String Name="";
    private int Tybe=0,Count=0,Price=0;
    
    public Food(String Name,int Price,int Tybe,int Count){
        
        this.Name=Name;
        this.Price=Price;
        this.Tybe=Tybe;
        this.Count=Count;
    }
    
    public String GetName(){
        return Name;
    }
    public int GetPrice(){
        return Price;
    }
    public int GetTybe(){
        return Tybe;
    }
    public int GetCount(){
        return Count;
    }
    
    public void SetCount(){
        this.Count++;
    }
    
    public String toString(){
        return Name+"  "+Price;
    }
}
