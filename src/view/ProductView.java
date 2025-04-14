package view;

import color.Color;
import controller.ProductController;
import model.Product;
import model.dao.ProductDaoImpl;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProductView {
    private void showMenu() {
        System.out.println(Color.setYellow("=".repeat(60)));
        System.out.println("1. Set Up Stock and Catalogue");
        System.out.println("2. View Products in Stock");
        System.out.println("3. Insert Product to Stock Catalogue");
        System.out.println("4. Update Product in Stock Catalogue by Product name");
        System.out.println("5. Delete Product from Stock Catalogue by Product name");
        System.out.println("6. View Insertion History in Stock Catalogue");
        System.out.println(Color.setRed("7. Exit"));
        System.out.println(Color.setYellow("=".repeat(60)));
        System.out.print(Color.setBlue("▶️ Insert your option: "));
    }

    public void App(Scanner scanner, ProductDaoImpl productDao, Product product, ProductController productController) {
        byte option = -1;
        do {
            showMenu();
            try {
                option = scanner.nextByte();

            } catch (InputMismatchException e) {
                System.out.println(Color.setRed("❌ Invalid, Only numbers are allowed."));
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1 -> {
                    System.out.println(Color.setPurple("=".repeat(20)+" Set Up Stock and Catalogue ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.setStockCatalogue(scanner, productDao);
                }
                case 2 -> {
                    System.out.println(Color.setPurple("=".repeat(20)+" View Products in Stock ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.displayStock(productDao);
                }
                case 3 -> {
                    System.out.println(Color.setPurple("=".repeat(20)+" Insert Product to Stock Catalogue ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.insertProduct(product, scanner, productDao);
                }
                case 4 -> {
                    System.out.println(Color.setPurple("=".repeat(20)+" Update Product in Stock Catalogue by Product name ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.updateProduct(product, scanner, productDao);
                }
                case 5 -> {
                    System.out.println(Color.setPurple("=".repeat(20)+" Delete Product from Stock Catalogue by Product name ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.deleteProduct(product, scanner, productDao);
                }
                case 6 -> {
                System.out.println(Color.setPurple("=".repeat(20)+" View Insertion History in Stock Catalogue ".toUpperCase(Locale.ROOT) + "=".repeat(20)));
                    productController.viewInsertionHistory(productDao);
                }
                case 7 -> System.out.println(Color.setGreen("🔻 Exited The Program."));
                default -> System.out.println(Color.setRed("❌ The options must be between 1 and 6"));

            }
        } while (option != 7);
    }

}
