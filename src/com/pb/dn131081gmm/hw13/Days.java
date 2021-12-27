package com.pb.dn131081gmm.hw13;

public enum Days {
    MON("Понедельник", 1),
    TUE("Вторник", 2),
    WED("Среда" ,3),
    THU("Четверг", 4),
    FRI("Пятница", 5),
    SAT("Субота", 6),
    SUN("Воскресенье", 7);
    final private String description;
    private int numnerDay;
    Days(String descrip, int num) {
        description = descrip;
        numnerDay = num;
    }

    public int getNumnerDay() {
        return numnerDay;
    }
    public String getDescription() {
        return description;
    }
    public static void getDay(int num){
    switch (num){
        case 1:
            System.out.println("\n" + MON.getDescription() + ":");
            break;
            case 2:
            System.out.println("\n" + TUE.getDescription() + ":");
                break;
            case 3:
            System.out.println("\n" + WED.getDescription() + ":");
                break;
        case 4:
            System.out.println("\n" + THU.getDescription() + ":");
            break;
        case 5:
            System.out.println("\n" + FRI.getDescription() + ":");
            break;
            case 6:
            System.out.println("\n" + SAT.getDescription() + ":");
                break;
        case 7:
            System.out.println("\n" + SUN.getDescription() + ":");
            break;
        default:
            System.out.println("Неизвестный день недели");
    }
    }
}


