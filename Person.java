public class Person{
    private String name;
    private Book[] rented;
    public Person(String name){
        this.name = name;
        this.rented = new Book[3];
    }

    public String getName(){
    return this.name;
    }

    public int rentedCount(){
        int count = 0;
        for (Book book: this.rented) {
            if (book!= null) {count++;}
        }
        return count;
    }

    public boolean isRentedFull(){
        return rentedCount() == rented.length;
    }

    public void add(Book book){
        if (!isRentedFull()){
            int rentedCount = rentedCount();
            this.rented[rentedCount] = book;
        }
    }

    public Book giveback(){
        if (rentedCount()!=0) {
            int rentedCount = rentedCount();
            Book book = this.rented[rentedCount-1];
            this.rented[rentedCount-1] = null;
            return book;
        }
        return null;
    }

    public void giveAllBack(){
        for (int i=0; i<this.rented.length ; i++) {
            this.rented[i] = null;
        }
    }
}
