package controller;

import model.Product;
import model.dao.ProductDaoImpl;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.Scanner;

public class ProductController {
    private final ProductService productService = new ProductServiceImpl();
    public void setStockCatalogue(Scanner scanner, ProductDaoImpl productDao) {
        productService.setStockCatalogue(scanner, productDao);
    }
    public void insertProduct(Product product,Scanner scanner, ProductDaoImpl productDao) {
        productService.insertProduct(product, scanner, productDao);
    }
    public void deleteProduct(Product product,Scanner scanner, ProductDaoImpl productDao) {
        productService.deleteProduct(product, scanner, productDao);
    }
    public void updateProduct(Product product,Scanner scanner, ProductDaoImpl productDao) {
        productService.updateProduct(product, scanner, productDao);
    }
    public void viewInsertionHistory(ProductDaoImpl productDao) {
        productService.viewInsertionHistory(productDao);
    }
    public void displayStock(ProductDaoImpl productDao) {
        productService.displayStock(productDao);
    }

}
