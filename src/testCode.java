//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class testCode {
//
//    public static final int USERINPUT = 2;
//
//    //creates multiple car objects:                   *************
//    public static void main(String[] args) {
//        List<Car> cars = new ArrayList<>();
//        for (int i = 0; i < USERINPUT; i++) {
//            cars.add(new Car("car_" + (i + 1)));
//        }
//        cars.get(0).setSpeed(1);
//        for (int object = 0; object < USERINPUT; object++) {
//            System.out.printf("%s going:%dseg/s at location:%s%n", cars.get(object).getId(), cars.get(object).getSpeed(), cars.get(object).getPosition());
//        }
//
////Simulation loop: that gets user input for each turn
//        Scanner simController = new Scanner(System.in);
//        System.out.println("Start Simulation?(y)");
//        String answer = simController.nextLine();
//        answer = answer.toLowerCase();
//        int carSpawns = simController.nextInt();
//        int turn = 0;
//        do {
//            turn = turn + 1;
//            for (int i = 0; i < carSpawns; i++) {
//                Car currentCar = cars.get(i);
//                int numOfRoad = simController.nextInt();
//                for (int j = 0; j<numOfRoad; j++){
//                    System.out.println("Please input parameters for road"+ j + "...");
//                    System.out.println("Length:");
//                    int lengthInput = simController.nextInt();
//                    System.out.println("Speed limit:");
//                    int speedLimitInput = simController.nextInt();
//                    TrafficLight currentLight = new TrafficLight("id_"+j, new Road((Integer.toString(j), speedLimitInput, lengthInput, new int[]{0,0})));
//                    System.out.println("How long for each light?");
//                    currentLight.operate(simController.nextInt());
//                    currentLight.printLightStatus();
//                    currentCar.move();
//                    currentCar.printCarStatus();
//                }
//            }
//
//
//            System.out.println("Sim turn = " + turn + "\nContinue Sim?(y)");
//            answer = simController.nextLine();
//            answer = answer.toLowerCase();
//        } while (answer.equals("y"));
//    }
//}