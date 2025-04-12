package mapper;

import model.Product;
import model.dto.ProductDto;

public class Mapper {
    public static ProductDto mapFromProductToProductDto(Product product) {
        if (product != null)
            return new ProductDto(product.getProductName());
        else
            return null;
    }
}
