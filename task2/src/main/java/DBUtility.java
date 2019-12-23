

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    /*
    * Каждый из тасков решается одним SQL запросом
     */

    /*
    Создать таблицу принтеры, Printer(id INTEGER AI PK U, model INTEGER, color TEXT, type TEXT, price INTEGER)
    добавить в нее 3 записи:
    1 1012 col laser 20000 (производитель HP)
    2 1010 bw jet 5000 (производитель Canon)
    3 1010 bw jet 5000 (производитель Canon)
    Каждая вставка в таблицу принтер должна отражаться добавлением записи в таблицу продукт
     */


    void AddPrinters(Statement stmt){
        // TODO: 16.12.2019  
    }


    public void createPrinterTable(Connection con, Statement  stmt){
        // TODO: 16.12.2019  
    }

    /*
    * Метод должен вернуть список уникальных моделей PC дороже 15 тысяч
     */

    public ArrayList<String> selectExpensivePC(Statement stmt){
        //todo
        return null;
    }

    /*
     * Метод должен вернуть список id ноутов, скорость процессора
     * которых выше чем 2500
     */

    public ArrayList<Integer> selectQuickLaptop(Statement stmt) {
        // TODO: 16.12.2019  
        return null;
    }

    /*
     * Метод должен вернуть список производителей которые
     *  делают и пк и ноутбуки
     */
    public ArrayList<String> selectMaker(Statement stmt){
        ArrayList<String> ans = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("select maker, count(maker) as counter from \n" +
                    "(select DISTINCT * from product) group by maker having counter >= 2;");
            while (rs.next()) {
                ans.add(rs.getString("maker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }

    /*
     * Метод должен вернуть максимальную среди всех произодителей
     * суммарную стоимость всех изделий типов ноутбук или компьютер,
     * произведенных одним производителем
     * Необходимо объединить таблицы продуктов ноутбуков и компьютеров
     * и отгрупировать по сумме прайсов после чего выбрать максимум
     * или сделать любым другим способом
     */

    public int makerWithMaxProceeds(Statement stmt){
        int result = 0;
        try {
            ResultSet rs = stmt.executeQuery("SELECT MAX(SUMM) as ANS from(select DISTINCT maker, sum(price) as SUMM from \n" +
                    "(select distinct id, maker, price from PC join Product on pc.model = product.model\n" +
                    "UNION\n" +
                    "select distinct id, maker, price from Laptop join Product on Laptop.model = product.model) \n" +
                    "group by maker);");
            rs.next();
            result = rs.getInt("ANS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
