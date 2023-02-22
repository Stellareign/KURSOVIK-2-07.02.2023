package TaskList.Enums;

public enum Type {
    WORK ("Рабочая задача"),
    PERSONAL ("Личная задача");
private String type;

    Type(String type) {
        this.type = type;
    }
    //    Type(String type) throws IllegalArgumentException {
//        try {
//            if (type != null && !type.isBlank() && type.isEmpty()) {
//                this.type = type;
//            } else throw new IncorrectArgumentException("Укажите тип задачи!");
//        } catch (IncorrectArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

    public Type setType(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return getType();
    }

    @Override
    public String toString() {
        return  type ;
    }
}
