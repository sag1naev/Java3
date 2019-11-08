import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    /*
    * Каждый из тасков решается одним SQL запросом
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection con =
                DriverManager.getConnection("jdbc:sqlite:/Users/levinmk/IdeaProjects/Java3/homework.db");
        Statement statement = con.createStatement();
        ResultSet res = statement.executeQuery("select * from PC");
        while (res.next()){
            for (int i = 1; i < 7; i++) {
                System.out.print(res.getInt(i) + " ");
            }
            System.out.println();
        }
    }

    /*
    Создать таблицу принтеры, Printer(id INTEGER AI PK U, model INTEGER, color TEXT, type TEXT, price INTEGER)
    добавить в нее 3 записи:
    1 1012 col laser 20000 (производитель HP)
    2 1010 bw jet 5000 (производитель Canon)
    3 1010 bw jet 5000 (производитель Canon)
    Каждая вставка в таблицу принтер должна отражаться добавлением записи в таблицу продукт
     */

    void createPrinterTable(Statement stmt){
        //TODO
    }

    /*
    * Метод должен вернуть список уникальных моделей PC дороже 15 тысяч
     */

    ArrayList<String> selectExpensivePC(Statement stmt){
        //TODO
        return null;
    }

    /*
     * Метод должен вернуть список id ноутов, скорость процессора
     * которых выше чем 2500
     */

    ArrayList<Integer> selectQuickLaptop(Statement stmt){
        //TODO
        return null;
    }

    /*
     * Метод должен вернуть список производителей которые делают и пк и ноутбуки
     */
    ArrayList<String> selectMaker(Statement stmt){
        //TODO
        return null;
    }
    /*
     * Метод должен вернуть максимальную среди всех произодителей
     * суммарную стоимость всех изделий типов ноутбук или компьютер,
     * произведенных одним производителем
     * Необходимо объединить таблицы продуктов ноутбуков и компьютеров
     * и отгрупировать по сумме прайсов после чего выбрать максимум
     * или сделать любым другим способом
     */
    int makerWithMaxProceeds(){
        //TODO
        return 0;
    }
}
