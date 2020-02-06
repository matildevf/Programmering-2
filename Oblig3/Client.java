package Oblig3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Client {
    public String printTickets(Ticket[] tickets) {
        if (tickets == null) return "No tickets \n";
        String string = "";
        for (Ticket t : tickets) {
            if (t != null) string += t.toString() + "\n";
        }
        return string;
    }

    public String printTribune(Tribune[] tribunes) {
        String string = "";
        for (Tribune t : tribunes) {
            if (t != null) string += t.toString();
        }
        return string;
    }

    public static void main(String[] args) {
        Client C = new Client();

        Tribune[] tribune = new Tribune[4];

        tribune[0] = new Stand("Stand1", 1000, 300);
        tribune[1] = new Stand("Stand2", 1000, 300);
        tribune[2] = new Sit("Sit", 500, 500, 20);
        tribune[3] = new VIP("VIP", 200, 800,8);

        System.out.println(C.printTribune(tribune));

        int numbT = 7;
        Ticket[] tickets;
        tickets = tribune[0].buyTickets(numbT);
        System.out.println(C.printTickets(tickets));
        tickets = tribune[1].buyTickets(numbT);
        System.out.println(C.printTickets(tickets));
        tickets = tribune[2].buyTickets(numbT);
        System.out.println(C.printTickets(tickets));
        tickets = tribune[3].buyTickets(numbT);
        System.out.println(C.printTickets(tickets));
        String[] names = new String[] {"Per", "Pål", "Geir", "Bjarne", "Berit", "Mari", "Bente"};
        tickets = tribune[3].buyTickets(names);
        System.out.println(C.printTickets(tickets));

        System.out.println("Sorted:");
        Comparator c = Collections.reverseOrder(new SortByIncome());
        Arrays.sort(tribune, c);
        System.out.println(C.printTribune(tribune));

    }
}

class SortByIncome implements Comparator<Tribune>
{
    public int compare(Tribune a, Tribune b)
    {
        return a.findIncome() - b.findIncome();
    }
}