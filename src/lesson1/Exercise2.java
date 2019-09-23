package lesson1;

public class Exercise2<T> {

    T obj;

    public Exercise2(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
//        int a = 12, b = -12;
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(b));
        Exercise2<Integer> ex1 = new Exercise2<>(12);
        Exercise2<Double> ex2 = new Exercise2<>(2.);
        Exercise2<String> ex3 = new Exercise2<>("asfasf");
        System.out.println(ex1.getObj().longValue());
        System.out.println(ex2.getObj().isInfinite());
        System.out.println(ex3.getObj().contains("sf"));
        System.out.println(ex1.obj);
        ex1.setObj((1 << 31) - 1);
        System.out.println(ex1.getObj());

    }

}
