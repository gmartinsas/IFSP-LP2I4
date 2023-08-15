/* Gabriel Martins - CB3021521 */

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author[] authors, double price) {
        new Book(name, authors, price, 0);
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return String.format("Book[name=%s],authors={%s},price=%s,qty=%s]", name, getAuthorNames(), price, qty);
    }

    public String getAuthorNames() {
        String n = "";
        for (int i = 0; i < authors.length; i++) {
            n += authors[i].toString() + ',';
        }
        return n;
    }
}