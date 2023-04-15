package martinfowler.chapter10_6;

public class Employee {

    private Double salary = 0.0;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * tenPercentRaise()和fivePercentRaise()做着类似的工作，因为少数值例如1.1,1.05导致
     * 其行为略有不同
     */
    void tenPercentRaise() {
        salary *= 1.1;
    }

    void fivePercentRaise() {
        salary *= 1.05;
    }


}
