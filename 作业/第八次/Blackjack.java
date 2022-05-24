/**
 * @Author: fengsc
 * @Date: 2022-05-24 13:21:19
 * @LastEditTime: 2022-05-24 15:46:19
 */
import java.util.*;
import java.util.stream.Collectors;

class Card implements Comparable<Card> {
    String suit;
    String number;
    Map<String, Integer> numberOrder = new HashMap<>() {
        {
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };
    Map<String, Integer> suitOrder = new HashMap<>() {
        {
            put("Spade", 0);
            put("Heart", 1);
            put("Diamond", 2);
            put("Club", 3);
        }
    };

    Card(String suit, String number) {
        this.suit = suit;
        this.number = number;
    }

    int getNumber() {
        if (number.equals("A")) {// 默认返回1
            return 1;
        }
        if (number.equals("J") || number.equals("Q") || number.equals("K")) {
            return 10;
        } else
            return Integer.parseInt(number);
    }

    @Override
    public int compareTo(Card o) {

        if (number.equals(o.number)) {
            return Integer.compare(suitOrder.get(suit), suitOrder.get(o.suit));
        }
        return Integer.compare(numberOrder.get(number), numberOrder.get(o.number));
    }

    @Override
    public String toString() {
        return suit + number;
    }
}


class Hand {
    List<Card> cards = new ArrayList<>();

    void add(Card card) {
        cards.add(card);
    }

    int points() {
        return cards.stream().collect(Collectors.summingInt(Card::getNumber));
    }


    void sort() {
        Collections.sort(cards);
    }

    int nums() {
        return cards.size();
    }
}


class Player {
    Hand hand = new Hand();
    boolean existA = false;



    void hit(Card card) {
        System.out.println("Hit");
        hand.add(card);
        if (card.number.equals("A")) {
            existA = true;
            System.out.println(card.suit + " 1 11");

        } else {
            System.out.println(card.suit + " " + card.getNumber());
        }
    }

    void stand() {
        System.out.println("Stand");
        hand.sort();
        for (Card card : hand.cards) {
            System.out.print(card + " ");
        }
        System.out.println();

    }

    int points() {
        int points = hand.points();
        if (existA && points + 10 <= 21) {
            return points + 10;
        }
        return points;
    }

    void check() {
        if (points() > 21) {
            System.out.println("Bust");
        } else if (points() == 21&&hand.nums()==2) {
            System.out.println("Blackjack");
        } else {
            System.out.println(points());
        }
    }



    void play(Scanner input) {
        while (true) {
            if (points() < 17) {
                Card card = new Card(input.next(), input.next());
                if (hand.nums() < 2) {
                    if (card.number.equals("A"))
                        existA = true;
                    hand.add(card);
                } else
                    hit(card);
            } else {
                stand();
                check();
                break;
            }
        }
    }


}


public class Blackjack {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(new Scanner(System.in));
    }

}
