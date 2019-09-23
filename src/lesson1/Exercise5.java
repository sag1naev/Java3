package lesson1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;

public class Exercise5<T extends Comparable<T>> {

    private T obj;

    public Exercise5(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public int compare(Exercise5<T> other){
        return obj.compareTo(other.getObj());
    }

    @Override
    public String toString() {
        return obj.toString();
    }

    public static void main(String[] args) {
        Exercise5<Man> e1 = new Exercise5<>(new Man(12, 170));
        Exercise5<Man> e2 = new Exercise5<>(new Man(15, 11));
        ArrayList<Exercise5<Man>>  data = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            data.add(new Exercise5<>(new Man(rnd.nextInt(1000),
                    100 + rnd.nextInt(150))));
        }
        data.sort(Comparator.comparing(Exercise5::getObj));
        System.out.println(data);
    }

}
