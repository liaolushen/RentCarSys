import java.util.*;

public class Initail {
    public static void main(String[] args) {
        Initail init = new Initail();
        Auto[] autos = init.dataInit();
        System.out.println("欢迎使用答答租车系统：");
        System.out.println("您是否要租车：1是 0否");
        Scanner scan = new Scanner(System.in);
        while(true) {
            String input = scan.next();
            if (input.equals("1")) {
                init.printAutoInfo(autos);
                System.out.println("请输入你要租的汽车数量");
                int auto_num = scan.nextInt();
                int[] rentNum = new int[auto_num+1];
                for (int i = 1; i <= auto_num; i++) {
                    System.out.println("请输入第"+i+"辆车的序号");
                    rentNum[i-1] = scan.nextInt();
                }
                System.out.println("请输入租车天数");
                int rentDays = scan.nextInt();
                System.out.println("您的账单:");
                // 根据输入进行处理
                String takePeopleAutos = "";
                String takeThingsAutos = "";
                int totlePeopleNum = 0;
                int totleThingsNum = 0;
                int dayPrice = 0;
                for (int i = 0; i < auto_num; i++) {
                    Auto auto = autos[rentNum[i]-1];
                    dayPrice += auto.autoPrice;
                    if (auto instanceof Car) {
                        Car car = (Car)auto;
                        takePeopleAutos += " "+car.autoName;
                        totlePeopleNum += car.peopleNum;
                    } else if (auto instanceof Truck) {
                        Truck truck = (Truck)auto;
                        takeThingsAutos += " "+truck.autoName;
                        totleThingsNum += truck.thingsNum;
                    } else if (auto instanceof Pickup) {
                        Pickup pickup = (Pickup)auto;
                        takeThingsAutos += " "+pickup.autoName;
                        takePeopleAutos += " "+pickup.autoName;
                        totlePeopleNum += pickup.peopleNum;
                        totleThingsNum += pickup.thingsNum;
                    }
                }
                int totlePrice = dayPrice*rentDays;
                // 输出处理结果
                System.out.println("***可载人的车有:");
                System.out.println(takePeopleAutos + "   共载人:"+totlePeopleNum);
                System.out.println("***可载货的车有:");
                System.out.println(takeThingsAutos + "   共载货:"+totleThingsNum);
                System.out.println("***租车总价格:"+totlePrice+"元");
                return;
            } else if (input.equals("0")) {
                return;
            } else {
                System.out.println("错误的指令！请重新输入");
            }
        }
    }

    public Auto[] dataInit() {
        Auto[] autos = {
            new Car("奥迪A4", 500, 4),
            new Car("马自达6", 400,4),
            new Pickup("皮卡雪6", 450, 4, 2),
            new Car("金龙", 800, 20),
            new Truck("松花江", 400, 4),
            new Truck("依维柯", 1000, 20),
        };
        return autos;
    }

    public void printAutoInfo(Auto[] autos) {
        System.out.println("您可租车的类型及价目表：");
        System.out.printf("%s\t%s\t%s\t\t%s\n", "序号", "汽车名称", "租金", "容量");
        for (int i = 0; i < autos.length; i++) {
            int  id = i+1;
            if (autos[i] instanceof Car) {
                Car auto = (Car)autos[i];
                System.out.printf("%s\t\t%s\t\t%s\t%s\n", id+".", auto.autoName, auto.autoPrice+"元/天", "载人:"+auto.peopleNum+"人");
            }
            if (autos[i] instanceof Truck) {
                Truck auto = (Truck)autos[i];
                System.out.printf("%s\t\t%s\t\t%s\t%s\n", id+".", auto.autoName, auto.autoPrice+"元/天", "载货:"+auto.thingsNum+"吨");
            }
            if (autos[i] instanceof Pickup) {
                Pickup auto = (Pickup)autos[i];
                System.out.printf("%s\t\t%s\t\t%s\t%s\n", id+".", auto.autoName, auto.autoPrice+"元/天", "载人:"+auto.peopleNum+"人 "+"载货:"+auto.thingsNum+"吨");
            }
        }
    }
}