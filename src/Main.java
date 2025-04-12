import lombok.Data;
import model.Product;
import model.dao.ProductDaoImpl;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.Scanner;

@Data
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoImpl productDao = new ProductDaoImpl();
        Product product = new Product();
        ProductService productService = new ProductServiceImpl();

//        testing
        productService.setStockCatalogue(scanner, productDao);
        productService.insertProduct(product ,scanner, productDao);
    }
}
