public class Library{
    private String name;
    private Book[] stock;

    public Library(String name){
        this.name = name;
        this.stock = new Book[8];
    }

    public String getName(){
        return this.name;
    }

    public int stockCount(){
        int count = 0;
        for (Book book: this.stock){
            if (book!= null) {count++;}
        }
        return count;
    }

    public void add(Book book){
        if (!isStockFull()){
            int stockCount = stockCount();
            this.stock[stockCount]= book;
        }
    }

    public void remove(){
        if (stockCount()!= 0) {
            int stockCount = stockCount();
            this.stock[stockCount-1] = null;
        }
    }

    public boolean isStockFull(){
        return stockCount() == stock.length;
    }

    public void clearStock(){
        for (int i=0; i<this.stock.length ; i++) {
            this.stock[i] = null;
        }
    }
}
