import java.util.Scanner;
// 10 hours so far!
public class BudgetTracker {

    public static void main(String[] args) {

        ArrayList newArray = new ArrayList(1);

//        DEBUG DATA
//        Budget item1 = new Budget("Entertainment", 100, 120);
//        Budget item2 = new Budget("Food", 250, 135);
//        Budget item3 = new Budget("Bills", 400, 400);
//        Budget item4 = new Budget("Gas", 100, 40);
//
//        newArray.push(item1);
//        newArray.push(item2);
//        newArray.push(item3);
//        newArray.push(item4);


        int choice = 0;
        while (choice != 5) {
            Scanner getInfo = new Scanner(System.in);
            System.out.println("1.Add to budget\n2.Delete Item\n3.Add to Current\n4.View Current\n5.quit\n");
            System.out.println("What do you want to do: ");
            choice = getInfo.nextInt();

//          Add to Budget
            if (choice == 1) {
                System.out.println("Budget Type: ");
                getInfo.nextLine();
                String bType = getInfo.nextLine();

                System.out.println("Enter Goal: $");
                float goal = getInfo.nextFloat();

                System.out.println("Enter Current: $");
                float current = getInfo.nextFloat();

                Budget item = new Budget(bType, goal, current);
                newArray.push(item);
            }
//          Delete expense type
            else if (choice == 2) {
                showData(newArray);
                System.out.println("Which number:");
                int current = getInfo.nextInt();
                getInfo.nextLine();

                newArray.delete(current - 1);
            }
//          Add money to current
            else if (choice == 3) {
                showData(newArray);
                System.out.println("Which number:");
                int current = getInfo.nextInt();
                getInfo.nextLine();
                System.out.println("How much Money:");
                float add = getInfo.nextFloat();

                Object addItem = newArray.readData(current - 1);
                Budget added = (Budget) addItem;

                added.addCurrent(add);
            }
//          Display all budget data
            else if (choice == 4) {
                showData(newArray);
                System.out.println();
            }

        }

        System.out.println("Total current spent: $ " + addBudgetData(newArray, "current"));
        System.out.println("Total goal: $ " + addBudgetData(newArray, "goal"));
        showData(newArray);


    }

    static float addBudgetData(ArrayList newArray, String type) {
        float total = 0;

//      Loops through array for each budget type
        for (int i = 0; i < newArray.numElements; i++) {
            Object item = newArray.readData(i);
            Budget readData = (Budget) item;
//          Total the budget goals
            if (type.equals("goal"))
                total += readData.getGoal();
//          total the current money spent
            if (type.equals("current"))
                total += readData.getCurrent();

        }
        return total;
    }

    static void showData(ArrayList newArray) {
//      Loops through array for each budget type
        for (int i = 0; i < newArray.numElements; i++) {
//          I'm not sure if this is the best way
//          I get each object data and then cast it to the budget class
            Object item = newArray.readData(i);
            Budget readData = (Budget) item;
            readData.printBudget(i + 1);
        }
    }
}


