package dao.custom.impl;

import dao.custom.OrderDetailsDao;
import dao.custom.OrderDao;
import db.DBConnection;
import dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    OrderDetailsDao orderDetailsDao = new OrderDetailsDaoImpl();
    @Override
    public boolean saveOrder(OrderDto dto) throws SQLException{
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            String sql = "INSERT INTO orders VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getOrderID());
            preparedStatement.setString(2, dto.getDate());
            preparedStatement.setString(3, dto.getCustomerID());

            if (preparedStatement.executeUpdate() > 0) {
                boolean isDetailSaved = orderDetailsDao.saveOrderDetails(dto.getList());

                if (isDetailSaved) {
                    connection.commit();
                    return true;
                }
            }
        }catch (SQLException | ClassNotFoundException ex){
            connection.rollback();
            ex.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
        return false;
    }

    @Override
    public OrderDto lastOrder() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orders ORDER BY orderId DESC LIMIT 1";
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return new OrderDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    null
            );

        }
        return null;
    }
}
