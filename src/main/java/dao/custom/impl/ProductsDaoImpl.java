package dao.custom.impl;

import dao.custom.ProductsDao;
import dao.util.CrudUtil;
import dto.ProductsDto;
import entity.Products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public boolean save(Products entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO products VALUES(?,?,?,?)";
        return CrudUtil.execute(sql,entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }

    @Override
    public boolean update(Products entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE products SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return CrudUtil.execute(sql,entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand(),entity.getCode());
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from products WHERE code=?";
        return CrudUtil.execute(sql,value);
    }

    @Override
    public List<Products> getAll() throws SQLException, ClassNotFoundException {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()){
            list.add(new Products(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return list;
    }

    public ProductsDto getProductByCode(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM products WHERE code=?";
        try (ResultSet resultSet = CrudUtil.execute(sql,code)) {
            if (resultSet.next()) {
                return new ProductsDto(
                        resultSet.getString("code"),
                        resultSet.getString("description"),
                        resultSet.getDouble("unitPrice"),
                        resultSet.getInt("qtyOnHand")
                );
            }
        }
        return null;
    }
}
