import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


    void AddPrinters(Statement stmt) throws SQLException {
        insertNewValue(stmt, 1012, "col", "laser", 20000, "HP");
        insertNewValue(stmt, 1010, "bw", "jet", 5000, "Canon");
        insertNewValue(stmt, 1010, "bw", "jet", 5000, "Canon");
    }


    public void createPrinterTable(Connection con, Statement stmt) throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS  Printer (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, model INTEGER, color TEXT, type TEXT, price INTEGER);");
        AddPrinters(stmt);
    }

    private void insertNewValue(Statement stmt, int model, String color, String type, int price, String maker) throws SQLException {
        stmt.execute("INSERT INTO Printer(model, color, type , price) VALUES (" + model + ", '" + color + "', '" + type + "', " + price + ");");
        stmt.execute("INSERT INTO Product(maker, model, type) VALUES ('" + maker + "', " + model + ", '" + type + "');");
    }

    /*
     * Метод должен вернуть список уникальных моделей PC дороже 15 тысяч
     */

    public ArrayList<String> selectExpensivePC(Statement stmt) {
        ArrayList<String> result = new ArrayList<>();
        try (ResultSet expensiveModelPC = stmt.executeQuery("SELECT DISTINCT model FROM PC WHERE price > 15000;")) {
            while (expensiveModelPC.next()) {
                result.add(expensiveModelPC.getString("model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * Метод должен вернуть список id ноутов, скорость процессора
     * которых выше чем 2500
     */

    public ArrayList<Integer> selectQuickLaptop(Statement stmt) {
        ArrayList<Integer> result = new ArrayList<>();
        try (ResultSet expensiveModelPC = stmt.executeQuery("SELECT id FROM Laptop WHERE speed > 2500;")) {
            while (expensiveModelPC.next()) {
                result.add(expensiveModelPC.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * Метод должен вернуть список производителей которые
     *  делают и пк и ноутбуки
     */
    public ArrayList<String> selectMaker(Statement stmt) {
        ArrayList<String> result = new ArrayList<>();
        try (ResultSet expensiveModelPC = stmt.executeQuery("SELECT distinct maker FROM Product WHERE type IN ('PC', 'Laptop') GROUP BY type;")) {
            while (expensiveModelPC.next()) {
                result.add(expensiveModelPC.getString("maker"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * Метод должен вернуть максимальную среди всех произодителей
     * суммарную стоимость всех изделий типов ноутбук или компьютер,
     * произведенных одним производителем
     * Необходимо объединить таблицы продуктов ноутбуков и компьютеров
     * и отгрупировать по сумме прайсов после чего выбрать максимум
     * или сделать любым другим способом
     */

    public int makerWithMaxProceeds(Statement stmt) {
        try (ResultSet expensiveModelPC = stmt.executeQuery("SELECT SUM(price) as total FROM ( SELECT model, price FROM Laptop UNION SELECT model, price FROM PC ) as u LEFT JOIN Product ON u.model = Product.model GROUP BY maker ORDER BY total DESC LIMIT 1;")) {
            if (expensiveModelPC.next()) {
                return expensiveModelPC.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
