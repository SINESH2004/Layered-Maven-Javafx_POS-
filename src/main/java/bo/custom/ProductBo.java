package bo.custom;

import bo.SuperBo;
import dto.ProductsDto;

import java.sql.SQLException;
import java.util.List;

public interface ProductBo<T> extends SuperBo {
    boolean saveProduct(T dto) throws SQLException, ClassNotFoundException;
    boolean updateProduct(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteProduct(String id) throws SQLException, ClassNotFoundException;
    List<ProductsDto> allProducts() throws SQLException, ClassNotFoundException;
}
