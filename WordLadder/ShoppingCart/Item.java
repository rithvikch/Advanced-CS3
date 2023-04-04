public class Item {

    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;
    private boolean hasBulk;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
        hasBulk = false;

    }


    public Item(String name, double price, int bulkQty, double bulkPrice, boolean hasBulk){
        this.hasBulk = hasBulk;
        

    }

    public Item(String name, double price, int bulkQty, double bulkPrice){
        this(name, price);
        this.bulkPrice = bulkPrice;
        this.bulkQty = bulkQty;

        if (price < 0 || bulkPrice < 0 || bulkQty < 0){
            throw new IllegalArgumentException("error");
        }
        else {
            hasBulk = true;
        }


    }

    public double priceFor(int quantity){

        if (quantity < 0){
            throw new IllegalArgumentException("error");
        }

        if (hasBulk){
            if (quantity > bulkQty) {
                return quantity * bulkPrice;
            }
        }
        return quantity * price;
    }


    public boolean equals(Item item) {

        if (item.name.equals(this.name)){
            return true;
        }
        return false;



    }
    public String toString(){
        String fin = this.name + ", $" + this.price;

        if (hasBulk){
            fin += " (" + this.bulkPrice + " for " + this.bulkQty + ")";
        }
        return fin;



    }

    public String getName(){
        return name;
    }







}