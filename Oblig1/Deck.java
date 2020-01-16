import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Deck {
    ArrayList<Card> cards = new ArrayList<>();

    public void makeDeck() {
        for (int j = 1; j < 14; j++) {
            cards.add(new Card('S', j));
            cards.add(new Card('H', j));
            cards.add(new Card('D', j));
            cards.add(new Card('C', j));
        }
    }

    public Collection assign(int n) {
        Random rand = new Random();
        ArrayList<Card> randCards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Card c = cards.get(rand.nextInt(cards.size()));
            randCards.add(c);
            cards.remove(c);
        }
        return randCards.stream().collect(Collectors.toList());
    }

    public void spades(ArrayList<Card> list) {
        (list.stream().filter(c -> c.getSuit() == 'S')).forEach(c -> System.out.println(c));
    }

    public Collection hearts(ArrayList<Card> list) {
        return list.stream().filter(c -> c.getSuit()=='H').collect(Collectors.toList());
    }

    public Collection suite(ArrayList<Card> list) {
        return list.stream().map(Card::getSuit).collect(Collectors.toList());
    }

    public int value(ArrayList<Card> list) {
        return list.stream().map(Card::getFace).reduce((a, b) -> a+b).get();
    }

    public boolean queenOfSpades(ArrayList<Card> list) {
        return list.stream().anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12);
    }

    public boolean pokerFlush(ArrayList<Card> list) {
        Map<Character, Long> c = list.stream().map(Card::getSuit).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return c.values().stream().anyMatch(t -> t >= 5);
    }

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.makeDeck();
        ArrayList<Card> l = new ArrayList<>(myDeck.assign(7));
        System.out.println(l);
        myDeck.spades(l);
        System.out.println(
                myDeck.hearts(l)  + "\n" +
                myDeck.suite(l)  + "\n" +
                myDeck.value(l)  + "\n" +
                myDeck.queenOfSpades(l)  + "\n" +
                myDeck.pokerFlush(l)  + "\n");
    }
}
