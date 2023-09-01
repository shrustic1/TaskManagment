package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.*;

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
    public AbstractDao(String tableName) {
        this.tableName = tableName;
        createConnection();
    }
    public static Connection getConnection(){
        return conn;
    }
    public abstract T row2object(ResultSet rs) throws MyException;
    public abstract Map<String, Object> object2row(T object);
    public List<T> executeQuery(String query, Object[] params) throws MyException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null){
                for (int i=1; i<= params.length; i++){
                    stmt.setObject(i, params[i-1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<T>();
            while (rs.next()){
                resultList.add(row2object(rs));
            }
            return resultList;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }
    public T executeQueryUnique (String query, Object[] params) throws MyException{
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1){
            return result.get(0);
        } else{
            throw new MyException("Object not found.");
        }
    }
    private Map.Entry<String, String> prepareInsertParts (Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry : row.entrySet()){
            counter++;
            if (entry.getKey().equals("id")) continue;
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter){
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }
    private String prepareUpdateParts (Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry : row.entrySet()){
            counter++;
            if (entry.getKey().equals("id")) continue;
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }
    public void delete(int id) throws MyException{
        String sql = "DELETE FROM "+tableName+" WHERE id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }
}
