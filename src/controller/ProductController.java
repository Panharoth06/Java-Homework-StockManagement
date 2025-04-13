package controller;

import model.Product;
import model.dao.ProductDaoImpl;
import model.service.ProductService;
import model.service.ProductServiceImpl;

import java.util.Scanner;

public class ProductController {
    private final ProductService productService = new ProductServiceImpl();
    void insertProduct(Scanner scanner, ProductDaoImpl product) {
        productService.setStockCatalogue(scanner, product);
    }
    void deleteProduct(Scanner scanner, ProductDaoImpl product) {
        productService.setStockCatalogue(scanner, product);
    }
    void updateProduct(Scanner scanner, ProductDaoImpl product) {
        productService.setStockCatalogue(scanner, product);
    }

}
