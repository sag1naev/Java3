package lesson1;

public class Man implements Comparable<Man>{

    int money;
    int height;

    public Man(int money, int height) {
        this.money = money;
        this.height = height;
    }

    @Override
    public String toString() {
        //%d integer
        //%f real
        //%s string
        return String.format("Man{money=%d, height=%d}", money, height);

    }

    @Override
    public int compareTo(Man o) {
        if (money == o.money){
            return height - o.height;
        }
        return money - o.money;
    }
}
