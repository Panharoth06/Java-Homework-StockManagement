import lombok.Data;
import model.Product;
import model.dao.ProductDaoImpl;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.Scanner;

//@Data
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoImpl productDao = new ProductDaoImpl();
        Product product = new Product();
        ProductService productService = new ProductServiceImpl();

//        testing
        productService.setStockCatalogue(scanner, productDao);
        productService.insertProduct(product ,scanner, productDao);
        productService.insertProduct(product ,scanner, productDao);
        productService.updateProduct(product, scanner, productDao);
        productService.deleteProduct(product, scanner, productDao);
        productService.viewInsertionHistory(productDao);
    }
}

/* What to do next:
 * noted
 *  if the stock is fulled, don't display it to users when the insertion
 *  update & delete: only show the stock that has products
 */
