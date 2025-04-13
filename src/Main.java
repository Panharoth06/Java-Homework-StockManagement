import controller.ProductController;
import model.Product;
import model.dao.ProductDaoImpl;
import view.ProductView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoImpl productDao = new ProductDaoImpl();
        Product product = new Product();
        ProductController productController = new ProductController();
        ProductView productView = new ProductView();

        productView.App(scanner, productDao, product, productController);

    }
}

// What to do next validate on display stock (case 2)
// Design some UI


