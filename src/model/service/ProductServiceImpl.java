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
        System.out.print("Stock : ");
        for (int i = 0; i < productDao.getStockSize(); i++) System.out.print("");
        System.out.println("[+] Insert the product : ");
    }

    @Override
    public void updateProduct(Product product, Scanner scanner, ProductDaoImpl productDao) {

    }

    @Override
    public void deleteProduct(Product product, Scanner scanner, ProductDaoImpl productDao) {

    }
}
