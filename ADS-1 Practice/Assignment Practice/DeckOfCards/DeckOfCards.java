/**
 * @author Dharshak
 */
import java.util.*;
/**
 * Card class implementation
 * Card implements Comparable<Card> 
 */
class Card implements Comparable<Card> {
    String suit_value; // suit_value of 'String' type
    int value; // value of 'int' type

    // Card constructor
    Card(String s, int v) {
        suit_value = s;
        value = v;
    }

    // toString method for returning suit_value and value to String
    public String toString() {
        return suit_value + " " + value;
    }

    // compareTo method for comparing Card objects
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
    
    /**
     * Shuffle the cards in the deck array
     * @param deck Card[] type array
     */
    public Card[] shuffle_cards(Card[] deck) {

        for (int i = 0; i < deck.length; i++) {
            Random r = new Random();
            int j = r.nextInt(deck.length);
            Card t = deck[j];
            deck[j] = deck[i];
            deck[i] = t;
        }
        return deck; // return the shuffled deck array
    }

    /**
     * Sort the cars in the deck array
     * @param deck Card[] type array
     */
    public Card[] cards_sort(Card[] deck) {
        for (int i = 0; i < deck.length; i++) {
            for (int j = i ; j > 0 && deck[j].compareTo(deck[j - 1]) < 0; j--) {
                Card t = deck[j];
                deck[j] = deck[j - 1];
                deck[j - 1] = t;
            }
        }
        return deck; // return the sorted deck array
    }

    public static void main(String[] args) {

        String[] suits = {"spade","heart","clubs","diamond"}; // suits array of String[] array type
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; // values array of int[] array type
        Card[] deck = new Card[52]; // deck array of Card[] type, size of 52

        DeckOfCards dc = new DeckOfCards(); // object creation for DeckOfCards()
        
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                deck[index] = new Card(suits[i], values[j]); // Adding 52 cards to deck array
                index++;
            }
        }

        Card[] shuffled_deck = dc.shuffle_cards(deck); // shuffling the cards
        Card[] sorted_deck = dc.cards_sort(deck); // sorting the cards
        System.out.println(Arrays.toString(sorted_deck)); // printing the sorted array of cards deck
    }
}