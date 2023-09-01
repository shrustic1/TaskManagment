package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.sql.*;
import java.util.Properties;

public abstract class AbstractDao<T extends Idable> implements Dao<T>{
    private static Connection conn = null;
    private String tableName;
    private static void createConnection(){
        if (conn == null){
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties.sample").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                conn = DriverManager.getConnection(url,username,password);
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                Runtime.getRuntime().addShutdownHook(new Thread(){
                    @Override
                    public void run(){
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

}
