package model.dao;

import lombok.Data;
import model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class ProductDaoImpl implements ProductDao {
    private int stockSize;
    private int catalogueSize;
    private String[][] productNames;

    @Override
    public void setStockAndCatalogue(int stock) {
        this.stockSize = stock;
        productNames = new String[stockSize][];
        int catalogue;
        System.out.println("💡Insert the number of catalogues in each stock");
        for (int i = 0; i < stockSize; i++) {
            System.out.print("[+] Insert the number of catalogues in stock [ " + (i + 1) + " ]: ");
            do {
                try {
                    catalogue = new Scanner(System.in).nextInt();
                    if (catalogue <= 0) {
                        System.out.println("[!] Catalogue number need to be greater than 0");
                        continue;
                    }
                    productNames[i] = new String[catalogue];
                    this.catalogueSize = catalogue;
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("[!] Please, insert integer.");
                    new Scanner(System.in).nextLine();
                }
            } while (true);
        }
        System.out.println("✅ Stock and Catalogue are set up successfully.");
        displayStocks();
    }

    @Override
    public void insertProduct(Product product, int stock, int catalogue) {
        productNames[stock - 1][catalogue - 1] = product.getProductName();
        System.out.println("✅ Product is added successfully.");
        printSpecificStocks(stock);
    }

    @Override
    public void updateProduct(Product product, int stock, int catalogue) {

        productNames[stock - 1][catalogue - 1] = product.getProductName();
        System.out.println("✅ Product is updated successfully.");
        printSpecificStocks(stock);

    }

    @Override
    public void deleteProduct(int stock, int catalogue) {

        productNames[stock - 1][catalogue - 1] = null;
        System.out.println("✅ Product is deleted successfully.");
        printSpecificStocks(stock);

    }

    @Override
    public void displayStocks() {
        for (int i = 0; i < productNames.length; i++) {
            System.out.print("Stock [" + (i + 1) + "]: ");
            for (int j = 0; j < productNames[i].length; j++) {
                System.out.print(
                        (productNames[i][j] == null || productNames[i][j].isEmpty() ?
                                "[ " + (j + 1) + " - Empty ]"
                                :
                                "[ " + productNames[i][j] + " ]")
                );
            }
            System.out.println(isFulled(i) ? " - Available" : " - Not Available");
        }
    }

    public void printSpecificStocks(int stock) {
        if (stock < 1 || stock > productNames.length) {
            System.out.println("Invalid stock number.");
            return;
        }

        int row = stock - 1;
        System.out.print("Stock [" + stock + "]: ");

        for (int i = 0; i < productNames[row].length; i++) {
            System.out.print(
                    productNames[row][i] == null || productNames[row][i].isEmpty()
                            ? "[ " + (i + 1) + " - Empty ] "
                            : "[ " + productNames[row][i] + " ] "
            );
        }
        System.out.println(isFulled(row) ? "- Available" : "- Not Available");
    }

    private boolean isFulled(int stockIndex) {
        for (int j = 0; j < productNames[stockIndex].length; j++) {
            if (productNames[stockIndex][j] == null || productNames[stockIndex][j].isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
