package lesson1;

import java.util.Arrays;

public class Exercise1 {

    //alt + insert win, linux
    //command + N
    Object obj;

    public Exercise1(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1("12");
        Exercise1 ex2 = new Exercise1(12);
        Exercise1 ex3 = new Exercise1(new Exception());
        ex1.setObj(124);
        System.out.println(new char[]{'1', '2'});
        System.out.println(ex2.getObj().getClass());
        System.out.println(ex3.getObj().getClass());
        System.out.println(ex1.getObj().getClass());
        if(ex1.getObj() instanceof String) {
            System.out.println(((String) (ex1.getObj())).length());
        }
    }
}
