package lesson1;

public class Exercise4<T extends Number & Comparable<T>> {

    T obj;

    public Exercise4(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public boolean isPositive(){
        return obj.doubleValue() > 0.;
    }

    public static void main(String[] args) {
        Exercise4<Double> obj = new Exercise4<>(0.);
        System.out.println(obj.isPositive());
    }
}
