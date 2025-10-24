public class Main {

    public static void main(String[] args) {
        System.out.println("=== Exotic Car Dealership Decision Table Simulation ===\n");

        executeRule("Customer", "Logged Out", "In Stock");
        executeRule("Customer", "Logged In", "Out of Stock");
        executeRule("Admin", "Logged In", "In Stock");
        executeRule("Admin", "Logged In", "In Stock");
        executeRule("Admin", "Logged In", "Out of Stock");
        executeRule("Customer", "Logged Out", "Out of Stock");
    }

    public static void executeRule(String userType, String loginStatus, String itemStatus) {
        System.out.println("---- New Rule ----");
        System.out.println("User Type: " + userType);
        System.out.println("Login Status: " + loginStatus);
        System.out.println("Item Availability: " + itemStatus);

        if (loginStatus.equals("Logged Out")) {
            System.out.println("Action: Prompt user to login.");
        }

        if (userType.equals("Customer") && loginStatus.equals("Logged In") && itemStatus.equals("In Stock")) {
            System.out.println("Action: Allow vehicle search and purchase.");
        }

        if (userType.equals("Admin") && loginStatus.equals("Logged In")) {
            System.out.println("Action: Access inventory management tools.");
        }

        if (userType.equals("Admin") && loginStatus.equals("Logged In")) {
            System.out.println("Action: View sales report.");
        }

        if (itemStatus.equals("Out of Stock")) {
            System.out.println("Action: Display out-of-stock message.");
        }

        System.out.println("-------------------\n");
    }
}
