package landlark.entity.mapper;

import java.util.List;
import landlark.entity.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Product product);

    Product selectByPrimaryKey(String uid);

    List<Product> selectAll();

    int updateByPrimaryKey(Product product);
}