import model.Product;

public class View {
    static void showMenu() {
        System.out.println("=".repeat(30));
        System.out.println("1. Set Up Stock with Catalogue");
        System.out.println("2. View Products in Stock");
        System.out.println("3. Insert Product to Stock Catalogue");
        System.out.println("4. Update Product in Stock Catalogue by Product name");
        System.out.println("5. Delete Product from Stock Catalogue by Product name");
        System.out.println("6. View Insertion History in Stock Catalogue");
        System.out.println("7. Exit");
        System.out.println("=".repeat(30));
        System.out.print("[+] Insert option: ");

    }
}
