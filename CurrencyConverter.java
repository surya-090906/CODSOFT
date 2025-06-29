import java.util.Scanner;

public class CurrencyConverter {

    
    public static double fromUSD(String to, double amount) {
        switch (to) {
            case "INR": return amount * 83.2;
            case "EUR": return amount * 0.92;
            case "JPY": return amount * 157.3;
            case "GBP": return amount * 0.78;
            case "USD": return amount;
            default: return -1;
        }
    }

    
    public static double fromINR(String to, double amount) {
        switch (to) {
            case "USD": return amount / 83.2;
            case "EUR": return (amount / 83.2) * 0.92;
            case "JPY": return (amount / 83.2) * 157.3;
            case "GBP": return (amount / 83.2) * 0.78;
            case "INR": return amount;
            default: return -1;
        }
    }

    
    public static double fromEUR(String to, double amount) {
        switch (to) {
            case "USD": return amount / 0.92;
            case "INR": return (amount / 0.92) * 83.2;
            case "JPY": return (amount / 0.92) * 157.3;
            case "GBP": return (amount / 0.92) * 0.78;
            case "EUR": return amount;
            default: return -1;
        }
    }

    
    public static double fromJPY(String to, double amount) {
        switch (to) {
            case "USD": return amount / 157.3;
            case "INR": return (amount / 157.3) * 83.2;
            case "EUR": return (amount / 157.3) * 0.92;
            case "GBP": return (amount / 157.3) * 0.78;
            case "JPY": return amount;
            default: return -1;
        }
    }

    
    public static double fromGBP(String to, double amount) {
        switch (to) {
            case "USD": return amount / 0.78;
            case "INR": return (amount / 0.78) * 83.2;
            case "EUR": return (amount / 0.78) * 0.92;
            case "JPY": return (amount / 0.78) * 157.3;
            case "GBP": return amount;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Currency Converter ===");

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("Supported currencies: USD, INR, EUR, JPY, GBP");
            System.out.println("1. Convert Currency");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Exiting... Thank you for using the converter.");
                break;
            }

            sc.nextLine(); 

            System.out.print("Enter base currency: ");
            String base = sc.nextLine().toUpperCase();

            System.out.print("Enter target currency: ");
            String target = sc.nextLine().toUpperCase();

            System.out.print("Enter amount in " + base + ": ");
            double amount = sc.nextDouble();

            double result = -1;

            switch (base) {
                case "USD":
                    result = fromUSD(target, amount);
                    break;
                case "INR":
                    result = fromINR(target, amount);
                    break;
                case "EUR":
                    result = fromEUR(target, amount);
                    break;
                case "JPY":
                    result = fromJPY(target, amount);
                    break;
                case "GBP":
                    result = fromGBP(target, amount);
                    break;
                default:
                    System.out.println("Invalid base currency.");
                    continue;
            }

            if (result == -1) {
                System.out.println("Invalid target currency.");
            } else {
                System.out.printf("%.2f %s = %.2f %s\n", amount, base, result, target);
            }
        }

        sc.close();
    }
}
