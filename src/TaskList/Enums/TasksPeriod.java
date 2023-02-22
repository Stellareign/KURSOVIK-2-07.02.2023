package TaskList.Enums;

public enum TasksPeriod {
    WEEKLYTASK("Еженедельно"),
    MONTHLYTASK("Ежемесячно"),
    DALYTASK("Ежедневно"),
    YEARLYTASK("Ежегодно"),
    ONETIMETASK("Однократно");

    private String taksPeriod;
// конструктор:
    TasksPeriod(String taksPeriod) throws IllegalArgumentException {
//        try {
//            if (taksPeriod != null && !taksPeriod.isBlank() && !taksPeriod.isEmpty()) {
                this.taksPeriod = taksPeriod;
//            } else throw new IncorrectArgumentException("Укажите периодичность выполнения задачи!");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

    }
    // геттер, сеттер и тустринг:


    public String getTaksPeriod() {
        return taksPeriod;
    }

    public TasksPeriod setTaksPeriod(String taksPeriod) {
        this.taksPeriod = taksPeriod;
        return this;
    }

    @Override
    public String toString() {
        return  taksPeriod;
    }
}
