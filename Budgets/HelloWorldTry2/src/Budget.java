public class Budget{

    String name;
    float goal;
    float current;

    Budget() {}

    Budget(String name, float goal, float current) {
        this.name = name;
        this.goal = goal;
        this.current = current;
    }
//  Getters
    String getName() { return this.name; }
    float getGoal() { return this.goal; }
    float getCurrent() { return  this.current; }

//  Add to the current budget
    void addCurrent(double spent) {
        this.current += spent;
    }

//  Display all information from the budget class
    void printBudget(int num) {
        System.out.println(num + " " + getName() + "    Current: $" + getCurrent() + "  |  Goal: $" + getGoal());
    }

}
