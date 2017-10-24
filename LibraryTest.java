import static org.junit.Assert.assertEquals;
import org.junit.*;

public class LibraryTest{
    Library library;
    Book book;
    Person person;

    @Before
    public void before(){
        library = new Library("Merchant Library");
        book = new Book();
        person = new Person("Adam");
    }

    @Test
    public void hasName(){
        assertEquals("Merchant Library", library.getName());
    }

    @Test
    public void stockStartsEmpty(){
        assertEquals(0, library.stockCount());
    }

    @Test
    public void canAddBook(){
        library.add(book);
        library.add(book);
        library.add(book);
        library.add(book);
        assertEquals(4, library.stockCount());
    }

    @Test
    public void canRemoveBook(){
        library.add(book);
        library.add(book);
        library.add(book);
        library.add(book);
        library.remove();
        assertEquals(3, library.stockCount());
    }

    @Test
    public void stockIsFull(){
        for (int i=0; i<8 ; i++) {
            library.add(book);
        }
        assertEquals(true, library.isStockFull());
    }
//PERSON CLASS TESTING BELOW

    @Test
    public void personHasName(){
        assertEquals("Adam", person.getName());
    }

    @Test
    public void rentedStartsEmpty(){
        assertEquals(0, person.rentedCount());
    }

    @Test
    public void personCanAddBook(){
        person.add(book);
        person.add(book);
        assertEquals(2, person.rentedCount());
    }

    @Test
    public void personCanRemoveBook(){
        person.add(book);
        person.add(book);
        person.add(book);
        person.giveback();
        assertEquals(2, person.rentedCount());
    }

    @Test
    public void rentedAmountIsFull(){
        for (int i=0; i<3 ; i++) {
            person.add(book);
        }
        assertEquals(true, person.isRentedFull());
    }

    @Test
    public void canReturnBookToLibrary(){
        person.add(book);
        Book book = person.giveback();
        library.add(book);
        assertEquals(0, person.rentedCount());
        assertEquals(1, library.stockCount());
    }
}
