import java.util.*;
public class ShoppingCart {

    public ArrayList<ItemOrder> listoforders;

    public ShoppingCart(){
        listoforders = new ArrayList<ItemOrder>();
    }
    public void add(ItemOrder newOrder){
        boolean there = false;
        for (int i = 0; i < listoforders.size(); i++){
            if (listoforders.get(i).getItem().equals(newOrder.getItem())){
                listoforders.set(i, newOrder);
                there = true;
        }
        }
        if (!there){
            listoforders.add(newOrder);
        }
    }

    public double getTotal(){
        double total = 0;
        for (ItemOrder ord : listoforders){
            total += ord.getPrice();
        }
        return total;
    }


}