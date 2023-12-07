package dao.util;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String sql,Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pst = DBConnection.getInstance().getConnection().prepareStatement(sql);
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T)pst.executeQuery();
        }
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1),args[i]);
        }
        return (T)(Boolean)(pst.executeUpdate()>0);
    }
}
