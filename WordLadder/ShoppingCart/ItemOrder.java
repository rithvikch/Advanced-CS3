public class ItemOrder {

    public Item item;

    public int qty;

    public ItemOrder(Item item, int qty){

        this.item = item;
        this.qty = qty;

    }

    public double getPrice(){
        return item.priceFor(qty);
    }
    public Item getItem(){
        return item;
    }
    public boolean equals(ItemOrder order){
        if (order.getItem().equals(this.item)){
            return true;
        }
        return false;
    }

}