package Oblig3;

public class Sit extends Tribune{
    private int[] noBusy;

    public Sit(String tribuneName, int capacity, int price, int rows) {
        super(tribuneName, capacity, price, rows);
        noBusy = new int[rows];
    }

    public int findNumberOfSoldTickets() {
        int sold = 0;
        for (int i = 0; i < noBusy.length; i++) {
            sold += noBusy[i];
        }
        return sold;
    }

    public Ticket[] buyTickets(int numbT) {
        for (int i = 0; i < noBusy.length; i++) {
            if ((super.getCapacity()/noBusy.length) - noBusy[i] > numbT) {
                Ticket[] tickets = new Ticket[numbT];
                int place = noBusy[i]+1;
                for (int j = 0; j < numbT; j++) {
                    tickets[j] = new SittingTicket(getTribuneName(), getPrice(), i+1, place);
                    place++;
                }
                noBusy[i] += numbT;
                return tickets;
            }
        }
        return null;
    }

    public Ticket[] buyTickets(String[] names) {
        return buyTickets(names.length);
    }
}
