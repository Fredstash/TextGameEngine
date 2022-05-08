public class Budget {
    String name;
    float goal;
    float current;

    Budget() {
    }

    Budget(String name, float goal, float current) {
        this.name = name;
        this.goal = goal;
        this.current = current;
    }

    String getName() {
        return this.name;
    }

    float getGoal() {
        return this.goal;
    }

    float getCurrent() {
        return this.current;
    }

    void addCurrent(double spent) {
        this.current = (float)((double)this.current + spent);
    }

    void printBudget(int num) {
        System.out.println("" + num + " " + this.getName() + "    Current: $" + this.getCurrent() + "  |  Goal: $" + this.getGoal());
    }
}
