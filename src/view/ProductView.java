package view;

import color.Color;
import controller.ProductController;
import model.Product;
import model.dao.ProductDaoImpl;

import java.util.Scanner;

public class ProductView {
    private void showMenu() {
        System.out.println("=".repeat(30));
        System.out.println("1. Set Up Stock with Catalogue");
        System.out.println("2. View Products in Stock");
        System.out.println("3. Insert Product to Stock Catalogue");
        System.out.println("4. Update Product in Stock Catalogue by Product name");
        System.out.println("5. Delete Product from Stock Catalogue by Product name");
        System.out.println("6. View Insertion History in Stock Catalogue");
        System.out.println("7. Exit");
        System.out.println("=".repeat(30));
        System.out.print("▶️ Insert option: ");
    }

    public void App(Scanner scanner, ProductDaoImpl productDao, Product product, ProductController productController) {
        byte option = -1;
        do {
            showMenu();
            option = scanner.nextByte();
            switch (option) {
                case 1 -> productController.setStockCatalogue(scanner, productDao);
                case 2 -> productController.displayStock(productDao);
                case 3 -> productController.insertProduct(product, scanner, productDao);
                case 4 -> productController.updateProduct(product, scanner, productDao);
                case 5 -> productController.deleteProduct(product, scanner, productDao);
                case 6 -> productController.viewInsertionHistory(productDao);
                case 7 -> System.out.println(Color.setGreen("🔻 Exited The Program."));
                default -> {
                    System.out.println(Color.setRed("❌ The options must be between 1 and 6"));
                }
            }
        } while (option != 7);
    }

}
