package bo.custom.Impl;

import bo.custom.ProductBo;
import dao.DaoFactory;
import dao.custom.ProductsDao;
import dao.util.DaoType;
import dto.ProductsDto;
import entity.Customer;
import entity.Products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductBoImpl implements ProductBo<ProductsDto> {
    private ProductsDao productsDao = DaoFactory.getInstance().getDao(DaoType.PRODUCTS);


    @Override
    public boolean saveProduct(ProductsDto dto) throws SQLException, ClassNotFoundException {
        return productsDao.save(new Products(
        dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQuantity()));
    }
    @Override
    public boolean updateProduct(ProductsDto dto) throws SQLException, ClassNotFoundException {
        return productsDao.update(new Products(
                dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQuantity()));
    }

    @Override
    public boolean deleteProduct(String id) throws SQLException, ClassNotFoundException {
        return productsDao.delete(id);
    }

    @Override
    public List<ProductsDto> allProducts() throws SQLException, ClassNotFoundException {
        List<Products> entityList = productsDao.getAll();
        List<ProductsDto> list = new ArrayList<>();
        for (Products products:entityList){
            list.add(new ProductsDto(
                    products.getCode(),
                    products.getDescription(),
                    products.getUnitPrice(),
                    products.getQtyOnHand()

            ));
        }
        return list;
    }
}
