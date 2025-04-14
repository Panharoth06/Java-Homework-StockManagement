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

// What to do next is validate on display stock (case 2) -> completed
// Design some UI

// If there is no insertion, when user choose view insertion history, display: "The products have not inserted yet" -> completed
// if the catalogue already has product, user cannot use that catalogue when insert -> completed
// validation catalogue, don't let user insert negative number - stock also (case 3) -> completed


