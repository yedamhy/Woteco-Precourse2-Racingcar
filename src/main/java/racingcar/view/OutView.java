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
}
