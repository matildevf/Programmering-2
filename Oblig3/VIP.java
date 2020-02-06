package Oblig3;

public class VIP extends Tribune{
    private String[][] spectator;

    public VIP(String tribuneName, int capacity, int price, int rows) {
        super(tribuneName, capacity, price, rows);
        spectator = new String[rows][super.getCapacity()/rows];
    }

    public int findNumberOfSoldTickets() {
        int sold = 0;
        for (int i = 0; i < spectator.length; i++) {
            sold += busySit(spectator[i]);
        }
        return sold;
    }

    public int busySit(String[] array) {
        int busy = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) busy += 1;
        }
        return busy;
    }

    public Ticket[] buyTickets(int numbT) {
        return null;
    }

    public Ticket[] buyTickets(String[] names) {
        for (int i = 0; i < spectator.length; i++) {
            if ((super.getCapacity()/spectator.length) - busySit(spectator[i]) > names.length) {
                Ticket[] tickets = new Ticket[names.length];
                int place = busySit(spectator[i])+1;
                for (int j = 0; j < names.length; j++) {
                    tickets[j] = new SittingTicket(getTribuneName(), getPrice(), i+1, place);
                    spectator[i][j] = names[j];
                    place++;
                }
                return tickets;
            }
        }
        return null;
    }
}
