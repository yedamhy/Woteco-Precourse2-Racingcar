package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

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
}
