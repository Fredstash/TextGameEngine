import java.util.Scanner;

public class BudgetTracker {
    public BudgetTracker() {
    }

    public static void main(String[] args) {
        ArrayList newArray = new ArrayList(1);
        int choice = 0;

        while(choice != 5) {
            Scanner getInfo = new Scanner(System.in);
            System.out.println("1.Add to budget\n2.Delete Item\n3.Add to Current\n4.View Current\n5.quit\n");
            System.out.println("What do you want to do: ");
            choice = getInfo.nextInt();
            float add;
            Budget added;
            if (choice == 1) {
                System.out.println("Budget Type: ");
                getInfo.nextLine();
                String bType = getInfo.nextLine();
                System.out.println("Enter Goal: $");
                add = getInfo.nextFloat();
                System.out.println("Enter Current: $");
                float current = getInfo.nextFloat();
                added = new Budget(bType, add, current);
                newArray.push(added);
            } else {
                int current;
                if (choice == 2) {
                    showData(newArray);
                    System.out.println("Which number:");
                    current = getInfo.nextInt();
                    getInfo.nextLine();
                    newArray.delete(current - 1);
                } else if (choice == 3) {
                    showData(newArray);
                    System.out.println("Which number:");
                    current = getInfo.nextInt();
                    getInfo.nextLine();
                    System.out.println("How much Money:");
                    add = getInfo.nextFloat();
                    Object addItem = newArray.readData(current - 1);
                    added = (Budget)addItem;
                    added.addCurrent((double)add);
                } else if (choice == 4) {
                    showData(newArray);
                    System.out.println();
                }
            }
        }

        System.out.println("Total current spent: $ " + addBudgetData(newArray, "current"));
        System.out.println("Total goal: $ " + addBudgetData(newArray, "goal"));
        showData(newArray);
    }

    static float addBudgetData(ArrayList newArray, String type) {
        float total = 0.0F;

        for(int i = 0; i < newArray.numElements; ++i) {
            Object item = newArray.readData(i);
            Budget readData = (Budget)item;
            if (type.equals("goal")) {
                total += readData.getGoal();
            }

            if (type.equals("current")) {
                total += readData.getCurrent();
            }
        }

        return total;
    }

    static void showData(ArrayList newArray) {
        for(int i = 0; i < newArray.numElements; ++i) {
            Object item = newArray.readData(i);
            Budget readData = (Budget)item;
            readData.printBudget(i + 1);
        }

    }
}