package battleships;

import java.sql.*;
import java.util.HashMap;
/**
 *
 * @author gmt3870
 */
public final class DBManager {
    private static final String USER_NAME = "battleships";
    private static final String PASSWORD = "battleships";
    private static final String URL = "jdbc:derby:BattleShipsDB; create=true";
    private Connection conn;
    private Statement statement;
    private final String DB_NAME = "Battleships";
    
    public DBManager() {
        establishConnection();
    }
    
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                statement = conn.createStatement();
                createTable();
                getAllData();
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
        
    private void createTable(){
        if(!this.checkExistedTable()){
            try {
                statement.executeUpdate("CREATE  TABLE " + this.DB_NAME + "  (TEAM  VARCHAR(50), SCORE INT)");
                statement.executeUpdate("INSERT INTO " + this.DB_NAME + " VALUES ('Player', 0), ('Bot', 0)");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    public boolean checkExistedTable() {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if (table_name.equalsIgnoreCase(this.DB_NAME)) {
                    return true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return false;
    }
}
