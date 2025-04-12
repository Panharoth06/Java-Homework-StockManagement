package model.dao;

import model.Product;

public interface ProductDao {
    void setStockAndCatalogue(int stock);
    void insertProduct(Product product, int stock, int catalogue);
    void updateProduct(Product product, int stock, int catalogue);
    void deleteProduct(int stock, int catalogue);
    void displayStocks();

}
