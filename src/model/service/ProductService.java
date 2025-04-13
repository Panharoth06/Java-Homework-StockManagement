package model.service;

import model.Product;
import model.dao.ProductDaoImpl;

import java.util.Scanner;

public interface ProductService {
    void setStockCatalogue(Scanner scanner, ProductDaoImpl productDao);
    void insertProduct(Product product, Scanner scanner, ProductDaoImpl productDao);
    void updateProduct(Product product, Scanner scanner, ProductDaoImpl productDao);
    void deleteProduct(Product product, Scanner scanner, ProductDaoImpl productDao);
    void viewInsertionHistory(ProductDaoImpl productDao);
    void displayStock(ProductDaoImpl productDao);
}
