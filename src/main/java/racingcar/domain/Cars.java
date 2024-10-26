package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void raceOne(){
        for(Car car : cars){
            if(isMove()){
                car.move();
            }
        }
    }

    private boolean isMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<Car> getAllCars(){
        return cars;
    }

    public List<Car> getWinners(){
        int maxPosition = findMaxPosition();

        List<Car> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    private int findMaxPosition(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
