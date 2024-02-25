import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poker {
    int[] suit = {1, 2, 3, 4};
    int[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};


    public void shuffleCards() {

        List<Poker> deck = new ArrayList<>();


        for (int i = 0; i < suit.length; i++) {
//            System.out.println(suit[i]);

            for (int j = 0; j < value.length; j++) {
//                System.out.println(value[j]);
                System.out.println(suit[i] + " - " + value[j]);

                deck.add(new Poker()); }


            }

            System.out.println("POKERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" + deck);
        }

        @Override
        public String toString () {
            return "Poker{" +
                    "suit='" + Arrays.toString(suit) + '\'' +
                    ", value='" + Arrays.toString(value) + '\'' +
                    '}';
        }

    }


