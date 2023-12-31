package battleships;

import java.sql.*;
import java.util.HashMap;
/**
 * Database manager
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
    
    /**
     * Create a connection with the database
     */
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
    
    /**
     * Create the database table if it doesn't exist
     */
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
    
    /**
     * Check if the table exists within the database
     * @return true if table exists, false otherwise
     */
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
    
    /**
     * Read all the data within the database
     * @return HashMap<String, Integer> of the data
     */
    public HashMap<String, Integer> getAllData(){
        String query = "SELECT TEAM, SCORE FROM " + this.DB_NAME;
        ResultSet rs;
        
        HashMap<String, Integer> data = new HashMap<>();
        
        try{
            Statement state = conn.createStatement();
            rs = state.executeQuery(query);
            while(rs.next()){
                String team = rs.getString("TEAM");
                int score = rs.getInt("SCORE");
                data.put(team, score);
            }
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        
        return data;
    }
    
    /**
     * Update the data in the database
     * @param data HashMap<String, Integer> of the data
     */
    public void updateData(HashMap<String, Integer> data){
        try {
            for (String team : data.keySet()) {
                String query = "UPDATE " + this.DB_NAME + "\n" +
                    "SET SCORE = " + data.get(team) + "\n" +
                    "WHERE TEAM = '" + team + "'";
                statement.addBatch(query);
            }
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
