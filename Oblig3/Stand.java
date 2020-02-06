package Oblig3;

public class Stand extends Tribune{
    private int noSoldTickets = 0;

    public Stand(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
    }

    public int findNumberOfSoldTickets() {
        return noSoldTickets;
    }

    public Ticket[] buyTickets(int numbT) {
        if (super.getCapacity() - noSoldTickets > numbT) {
            Ticket[] tickets = new Ticket[numbT];
            for (int i = 0; i < numbT; i++) {
                tickets[i] = new StandingTicket(getTribuneName(), getPrice());
            }
            noSoldTickets += numbT;
            return tickets;
        }
        return null;
    }

    public Ticket[] buyTickets(String[] names) {
        return buyTickets(names.length);
    }
}
