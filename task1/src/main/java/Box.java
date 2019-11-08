
/*use generics s*/

import java.util.ArrayList;

class Box<T extends Fruit> {

    ArrayList<T> fruits = new ArrayList<>();
    //используте ArrayList для хранения фруктов

    public float getWeight() {
        float weight = 0.0f;
        for (T frt :
                fruits) {
            weight += frt.getWeight();
        }
        return weight;
    }

    public boolean compareTo(Box<? extends Fruit> box) {
        return box.getWeight() == getWeight();
    }

    public void addFruit(T fruit)  {
        this.fruits.add(fruit);
    }

    public void dropFruits(Box<T> otherBox) throws DropException {
        try {
            otherBox.fruits.addAll(otherBox.fruits);
            this.fruits.clear();
        } catch (Exception e) {
            throw new DropException();
        }
    }
}

