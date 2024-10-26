package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutView {
    public static void printRaceStatus(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners){
        System.out.print("최종 우승자 : ");
        String winnerNames = String.join(", ",
                winners.stream()
                        .map(Car::getName)
                        .toList());

        System.out.println(winnerNames);
    }
}
