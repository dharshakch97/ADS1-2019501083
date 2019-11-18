import java.util.*;
class Card implements Comparable<Card> {
    String suit_value;
    int value;

    Card(String s, int v) {
        suit_value = s;
        value = v;
    }

    public String toString() {
        return suit_value + " " + value;
    }

    public int compareTo(Card t) {
        if (this.suit_value.compareTo(t.suit_value) < 0)
            return 1;
        else if (this.suit_value.compareTo(t.suit_value) > 0)
            return -1;
        else if (this.value < t.value)
                return -1;
        else if (this.value > t.value)
                return 1;
        else return 0;
        }
}

class DeckOfCards {
    
    public Card[] shuffle_cards(Card[] deck) {

        for (int i = 0; i < deck.length; i++) {
            Random r = new Random();
            int j = r.nextInt(deck.length);
            Card t = deck[j];
            deck[j] = deck[i];
            deck[i] = t;
        }
        return deck;
    }

    public Card[] cards_sort(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            for (int j = i ; j > 0 && deck[j].compareTo(deck[j - 1]) < 0; j--) {
                Card t = deck[j];
                deck[j] = deck[j - 1];
                deck[j - 1] = t;
            }
        }
        return deck;
    }
    public static void main(String[] args) {

        String[] suits = {"spade","heart","clubs","diamond"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Card[] deck = new Card[52];

        DeckOfCards dc = new DeckOfCards();
        
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                deck[index] = new Card(suits[i], values[j]);
                index++;
            }
        }

        Card[] shuffled_deck = dc.shuffle_cards(deck);
        Card[] sorted_deck = dc.cards_sort(deck);
        System.out.println(Arrays.toString(sorted_deck));
    }
}