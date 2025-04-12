import model.dao.ProductDao;
import model.dao.ProductDaoImpl;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoImpl productDao = new ProductDaoImpl();
        ProductService productService = new ProductServiceImpl();

//        testing
        productService.setStockCatalogue(scanner, productDao);
    }
}
