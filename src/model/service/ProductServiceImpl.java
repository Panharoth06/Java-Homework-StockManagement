package model.service;

import model.Product;
import color.Color;
import model.dao.ProductDaoImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    @Override
    public void setStockCatalogue(Scanner scanner, ProductDaoImpl productDao) {
        int stock;
        do {
            System.out.print(Color.setBlue("▶️ Insert the number of stocks: "));
            try {
                stock = scanner.nextInt();
                if (stock <= 0) {
                    System.out.println(Color.setYellow("⚠️ The number of stocks must be greater than 0."));
                    continue;
                } else
                    productDao.setStockAndCatalogue(stock);
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(Color.setRed("️❌Please, insert integer."));
                scanner.next();
                continue;
            }
        } while (true);
    }

    @Override
    public void insertProduct(Product product, Scanner scanner, ProductDaoImpl productDao) {
        int stock, catalogue;

        System.out.print("Stock: ");
        for (int i = 0; i < productDao.getStockSize(); i++) {
            System.out.print("| " + (i + 1) + " |");
        }

        System.out.println();

        while (true) {
            try {
                System.out.print(Color.setBlue("▶️ Insert the number of stock you want to insert: "));
                stock = scanner.nextInt();
                if (stock <= 0 || stock > productDao.getStockSize()) {
                    System.out.println(Color.setYellow("⚠️ The number of stocks must be between 1 and " + productDao.getStockSize() + "."));
                    continue;
                }

                productDao.printSpecificStocks(stock);

                System.out.print(Color.setBlue("▶️ Insert the catalogue number you want to insert: "));
                catalogue = scanner.nextInt();
                if (catalogue <= 0 || catalogue > productDao.getCatalogueSize()) {
                    System.out.println(Color.setYellow("⚠️ Invalid catalogue number. Please insert a number between 1 and " + productDao.getCatalogueSize() + "."));
                    continue;
                }

                scanner.nextLine();

                String name;
                do {
                    System.out.print(Color.setBlue("▶️ Insert the product name: "));
                    name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println(Color.setRed("❌ Product name cannot be empty. Please try again."));
                        continue;
                    }

                    if (!name.matches("[a-zA-Z0-9\\s]{2,30}")) {
                        System.out.println(Color.setRed("❌ Product name must be 2–30 characters long and contain only letters, numbers, or spaces."));
                        continue;
                    }

                    if (name.matches("\\d+")) {
                        System.out.println(Color.setRed("❌ Product name cannot be numbers only. Please include letters."));
                        continue;
                    }

                    break;
                } while (true);

                product.setProductName(name);
                productDao.insertProduct(product, stock, catalogue);
                System.out.println(Color.setGreen("✅ Product inserted successfully."));
                break;

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(Color.setRed("❌ Please insert a valid integer."));
                scanner.next();
                continue;
            }
        }
    }

    @Override
    public void updateProduct(Product product, Scanner scanner, ProductDaoImpl productDao) {
        int stock;

        while (true) {
            System.out.print("Stock: ");
            for (int i = 0; i < productDao.getStockSize(); i++) {
                System.out.print("| " + (i + 1) + " |");
            }

            System.out.println();
            try {
                System.out.print(Color.setBlue("▶️ Insert the number of stock you want to update: "));
                stock = scanner.nextInt();
                if (stock <= 0 || stock > productDao.getStockSize()) {
                    System.out.println(Color.setYellow("⚠️ The number of stocks must be between 1 and " + productDao.getStockSize() + "."));
                    continue;
                }

                productDao.printSpecificStocks(stock);
                scanner.nextLine();

                String name;
                do {
                    System.out.print(Color.setBlue("▶️ Insert the product name want to update: "));
                    name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println(Color.setRed("❌ Product name cannot be empty. Please try again."));
                        continue;
                    }

                    if (!name.matches("[a-zA-Z0-9\\s]{2,30}")) {
                        System.out.println(Color.setRed("❌ Product name must be 2–30 characters long and contain only letters, numbers, or spaces."));
                        continue;
                    }

                    if (name.matches("\\d+")) {
                        System.out.println(Color.setRed("❌ Product name cannot be numbers only. Please include letters."));
                        continue;
                    }

                    break;

                } while (true);

                if (productDao.isExisted(stock, name)) {
                    while (true) {
                    System.out.print(Color.setBlue("▶️ Insert new product name: "));
                    name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println(Color.setRed("❌ Product name cannot be empty. Please try again."));
                            continue;
                        }

                        if (!name.matches("[a-zA-Z0-9\\s]{2,30}")) {
                            System.out.println(Color.setRed("❌ Product name must be 2–30 characters long and contain only letters, numbers, or spaces."));
                            continue;
                        }

                        if (name.matches("\\d+")) {
                            System.out.println(Color.setRed("❌ Product name cannot be numbers only. Please include letters."));
                            continue;
                        }
                        break;
                    }
                    product.setProductName(name);
                    productDao.updateProduct(product, stock);
                }
                else {
                    System.out.println(Color.setYellow("⚠️ Product not existed. Please try again."));
                    continue;
                }
                break;

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(Color.setRed("❌ Please insert a valid integer."));
                scanner.next();
                continue;
            }
        }

    }

    @Override
    public void deleteProduct(Product product, Scanner scanner, ProductDaoImpl productDao) {
        int stock, catalogue;

        while (true) {
            System.out.print("Stock: ");
            for (int i = 0; i < productDao.getStockSize(); i++) {
                System.out.print("| " + (i + 1) + " |");
            }

            System.out.println();
            try {
                System.out.print(Color.setBlue("▶️ Insert the number of stock you want to delete: "));
                stock = scanner.nextInt();
                if (stock <= 0 || stock > productDao.getStockSize()) {
                    System.out.println(Color.setYellow("⚠️ The number of stocks must be between 1 and " + productDao.getStockSize() + "."));
                    continue;
                }

                productDao.printSpecificStocks(stock);

                scanner.nextLine();

                String name;
                do {
                    System.out.print(Color.setBlue("▶️ Insert the product name you want to delete: "));
                    name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println(Color.setRed("❌ Product name cannot be empty. Please try again."));
                        continue;
                    }

                    break;
                } while (true);

                if (productDao.isExisted(stock, name)) {
                    product.setProductName(name);
                    productDao.deleteProduct(stock, product);
                }
                else {
                    System.out.println(Color.setYellow("⚠️ Product not existed. Please try again."));
                    continue;
                }
                break;

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println(Color.setRed("❌ Please insert a valid integer."));
                scanner.next();
                continue;
            }
        }
    }
    @Override
    public void viewInsertionHistory(ProductDaoImpl productDao) {
        productDao.viewInsertionHistory();
    }
}
