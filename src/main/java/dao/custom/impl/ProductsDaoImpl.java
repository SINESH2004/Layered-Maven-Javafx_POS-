package dao.custom.impl;

import dao.custom.ProductsDao;
import dao.util.CrudUtil;
import dao.util.hibernateUtil;
import dto.ProductsDto;
import entity.Customer;
import entity.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public boolean save(Products entity) throws SQLException, ClassNotFoundException {
        Session session = hibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Products entity) throws SQLException, ClassNotFoundException {
        Session session = hibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Products products = session.find(Products.class, entity.getCode());
        products.setDescription(entity.getDescription());
        products.setQtyOnHand(entity.getQtyOnHand());
        products.setUnitPrice(entity.getUnitPrice());
        session.save(products);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session = hibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Products.class,value));
        transaction.commit();
        return true;
    }

    @Override
    public List<Products> getAll() throws SQLException, ClassNotFoundException {
        Session session = hibernateUtil.getSession();
        Query query = session.createQuery("FROM Products");
        List<Products> list = query.list();
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
