package Oblig3;

public abstract class Tribune {
    private final String tribuneName;
    private final int capacity;
    private final int price;
    private int rows;

    public Tribune(String tribuneName, int capacity, int price) {
        this.tribuneName = tribuneName;
        this.capacity = capacity;
        this.price = price;
    }

    public Tribune(String tribuneName, int capacity, int price, int rows) {
        this.tribuneName = tribuneName;
        this.capacity = capacity;
        this.price = price;
        this.rows = rows;
    }

    public String getTribuneName() {
        return tribuneName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public abstract int findNumberOfSoldTickets();

    public int findIncome() {
        return price * findNumberOfSoldTickets();
    }

    public abstract Ticket[] buyTickets(int numbT);

    public abstract Ticket[] buyTickets(String[] names);

    public String toString() {
        return "Tribune: " + tribuneName + ", Capacity: " + capacity + ", Sold tickets: " + findNumberOfSoldTickets() + ", Income: " + findIncome() + "\n";
    }
}
