/**
 * @Author: fengsc
 * @Date: 2022-03-30 19:17:01
 * @LastEditTime: 2022-03-30 19:27:32
 */
package music1;
import music.Note;

interface Instrument {
    int value = 5;

    default void play(Note n) {
        System.out.println(this + ".play() " + n);

    }

    default void adjust() {
        System.out.println("Adjusting " + this);

    }
}

class Wind implements Instrument {
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument {
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Music {
    static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
        new Wind(),
        new Percussion(),
        new Stringed(),
        new Brass(),
        new Woodwind()
        };
        tuneAll(orchestra);
        }

}
// Wind.play() MIDDLE_C
// Percussion.play() MIDDLE_C
// Stringed.play() MIDDLE_C
// Brass.play() MIDDLE_C
// Woodwind.play() MIDDLE_C