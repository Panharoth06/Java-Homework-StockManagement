package model.dao;

import color.Color;
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
    private static int count = 0;

    private String[][] productNames;
    private Date[][] insertionDate;

    @Override
    public void setStockAndCatalogue(int stock) {
        this.stockSize = stock;
        productNames = new String[stockSize][];
        insertionDate = new Date[stockSize][];
        Scanner scanner = new Scanner(System.in);

        System.out.println(Color.setPurple("💡 Insert the number of catalogues in each stock"));

        for (int i = 0; i < stockSize; i++) {
            int catalogue;
            while (true) {
                System.out.print(Color.setBlue("▶️ Insert the number of catalogues in stock [ " + (i + 1) + " ]: "));
                try {
                    catalogue = scanner.nextInt();
                    if (catalogue <= 0) {
                        System.out.println(Color.setYellow("⚠️ Catalogue number must be greater than 0."));
                        continue;
                    }

                    productNames[i] = new String[catalogue];
                    insertionDate[i] = new Date[catalogue];
                    break; // Valid input, exit loop
                } catch (InputMismatchException e) {
                    System.out.println(Color.setRed("[!] Please insert a valid integer."));
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }

        System.out.println(Color.setGreen("✅ Stock and Catalogue are set up successfully."));
        displayStocks();
    }


    @Override
    public void insertProduct(Product product, int stock, int catalogue) {
        productNames[stock - 1][catalogue - 1] = product.getProductName();
        insertionDate[stock - 1][catalogue - 1] = Date.from(Instant.now());
        count++;
        System.out.println(Color.setGreen("✅ Product is added successfully."));

        printSpecificStocks(stock);

    }

    @Override
    public void updateProduct(Product product, int stock) {
        int row = stock - 1;
        for (int i = 0; i < productNames[row].length; i++) {
            if (productNames[row][i] == null) continue;
            productNames[row][i] = product.getProductName();
            System.out.println(Color.setGreen("✅ Product is updated successfully."));
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
                System.out.println(Color.setGreen("✅ Product is deleted successfully."));
            }
        }

        printSpecificStocks(stock);

    }

    @Override
    public void displayStocks() {
        if (stockSize == 0) {
            System.out.println(Color.setYellow("The stock is empty."));
            return;
        }
        for (int i = 0; i < productNames.length; i++) {
            System.out.print("Stock [" + (i + 1) + "]: ");
            for (int j = 0; j < productNames[i].length; j++) {
                System.out.print(
                        (productNames[i][j] == null || productNames[i][j].isEmpty() ?
                                "[ " + (j + 1) + " - Empty ]"
                                :
                                "[ " + (j + 1) + " - " + productNames[i][j] + " ]")
                );
            }
            System.out.println(isNotFulled(i) ? Color.setGreen(" - Still Available") : Color.setYellow(" - Stock is fulled"));
        }
    }

    @Override
    public void viewInsertionHistory() {

        if (productNames == null || count == 0) {
            System.out.println(Color.setYellow("The insertion history is empty"));
            return;
        }
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
                    productNames[row][i] == null || productNames[row][i].isEmpty() ?
                            "[ " + (i + 1) + " - Empty ] "
                            :
                            "[ " + (i + 1) + " - " + productNames[row][i] + " ] "
            );
        }
        System.out.println(isNotFulled(row) ? Color.setGreen("- Still Available") : Color.setYellow("- Stock is fulled"));
    }

    public boolean isNotFulled(int stockIndex) {
        for (int i = 0; i < productNames[stockIndex].length; i++) {
            if (productNames[stockIndex][i] == null || productNames[stockIndex][i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasProduct(int stock) {
        for (int i = 0; i < productNames[stock].length; i++) {
            if (productNames[stock][i] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean IsCatalogueExists(int stock, int catalogue) {
        return productNames[stock - 1][catalogue - 1] != null;
    }

}
