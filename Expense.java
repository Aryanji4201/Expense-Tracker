import java.util.*;

public class Expense {
    int id;
    String description;
    double price;
    Expense(int id , String desc,double amt){
        this.id = id;
        description = desc;
        price = amt;
    }
//    void addExpense(String desc,double amt){
//
//    }
//    void statement(){
//
//    }
//    void delete(){
//
//    }
//    void updateExpense(int id, String desc , double amt ){
//
//    }
    static void saveToFile(List<Expense> expenses) {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter("expenses.txt");

            for (Expense e : expenses) {
                pw.println(e.id + "," + e.description + "," + e.price);
            }

            pw.close();
        } catch (Exception e) {
            System.out.println("Error saving f" +
                    "ile");

        }
    }
    static List<Expense> loadFromFile() {
        List<Expense> list = new ArrayList<>();

        try {
            java.io.File file = new java.io.File("expenses.txt");

            if (!file.exists()) return list;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String desc = parts[1];
                double amount = Double.parseDouble(parts[2]);

                list.add(new Expense(id, desc, amount));
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading file");
        }

        return list;
    }

}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Expense> expenses = Expense.loadFromFile();
        int idCounter = 1;
        for (Expense e : expenses) {
            if (e.id >= idCounter) {
                idCounter = e.id + 1;
            }
        }
        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Total Expense");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            if (choice == 1 ){
                System.out.println("Add selected");
                sc.nextLine();
                System.out.println("Enter description: ");
                String desc = sc.nextLine();
                System.out.println("Enter Amount: ");
                double amount = sc.nextDouble();
                Expense e = new Expense(idCounter++,desc,amount);
                expenses.add(e);
                System.out.println("Expenses added");
                Expense.saveToFile(expenses);


            }
            else if (choice == 2){
                System.out.println("view selected");
                if (expenses.isEmpty()) {
                    System.out.println("No expenses found.");
                } else {
                    for (Expense e : expenses) {
                        System.out.println(e.id + " | " + e.description + " | " + e.price);
                    }
                }
            }
            else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                boolean found = false;

                for (int i = 0; i < expenses.size(); i++) {
                    if (expenses.get(i).id == id) {
                        expenses.remove(i);
                        found = true;
                        System.out.println("Deleted successfully");
                        break;
                    }
                }

                if (found) {
                    Expense.saveToFile(expenses);
                }
                else {
                    System.out.println("Expense not found ");
                }
            }
            else if (choice == 4) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();

                boolean found = false;

                for (Expense e : expenses) {
                    if (e.id == id) {
                        System.out.print("New description: ");
                        e.description = sc.nextLine();

                        System.out.print("New amount: ");
                        e.price = sc.nextDouble();

                        found = true;
                        System.out.println("Updated successfully");

                        Expense.saveToFile(expenses); // ✅ correct place
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Expense not found");
                }
            }
            else if (choice == 5) {
                double total = 0;

                for (Expense e : expenses) {
                    total += e.price;
                }

                System.out.println("Total Expense: " + total);
            }
            else if (choice == 6) {
                break;
            }
            else {
                System.out.println("Invalid choice");
            }

        }
    }
}
