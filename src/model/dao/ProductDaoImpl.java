package model.dao;

import lombok.Data;
import model.Product;

import java.time.Instant;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class ProductDaoImpl implements ProductDao {
    private int stockSize;
    private int catalogueSize;
    private String[][] productNames;
    private Date[][] insertionDate;

    @Override
    public void setStockAndCatalogue(int stock) {
        this.stockSize = stock;
        productNames = new String[stockSize][];
        insertionDate = new Date[stockSize][];
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
                    insertionDate[i] = new Date[catalogue];
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
        insertionDate[stock - 1][catalogue - 1] = Date.from(Instant.now());
        System.out.println("✅ Product is added successfully.");
        printSpecificStocks(stock);
    }

    @Override
    public void updateProduct(Product product, int stock) {
        int row = stock - 1;
        for (int i = 0; i < productNames[row].length; i++) {
            if (productNames[row][i] == null) continue;
            productNames[row][i] = product.getProductName();
            System.out.println("✅ Product is updated successfully.");
            break;
        }
        printSpecificStocks(stock);
    }

    @Override
    public void deleteProduct(int stock, Product product) {
        int row = stock - 1;
        for (int i = 0; i < productNames[row].length; i++) {
            if (productNames[row][i] == null) continue;
            else if (productNames[row][i].equals(product.getProductName())) {
                productNames[row][i] = null;
                System.out.println("✅ Product is deleted successfully.");
            }
        }
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
            System.out.println(isFulled(i) ? " - Still Available" : " - Stock is fulled");
        }
    }

    @Override
    public void viewInsertionHistory() {
        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < productNames[i].length; j++) {
                if (insertionDate[i][j] == null) continue;
                System.out.println("Product " + productNames[i][j] + " inserted at " + insertionDate[i][j] + " ");
            }
        }
    }


//    helper methods
    public boolean isExisted(int stock, String name) {
        int row = stock - 1;
//   return productNames[stock - 1][catalogue - 1] != null;
        for (int i = 0; i < productNames[row].length; i++) {
            if (productNames[row][i] == null) continue;
            else if (productNames[row][i].equalsIgnoreCase(name))
                return true;
        }
        return false;
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
        System.out.println(isFulled(row) ? "- Still Available" : "- Stock is fulled");
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
