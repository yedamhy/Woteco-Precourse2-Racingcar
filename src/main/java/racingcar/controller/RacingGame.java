package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutView;

import java.util.List;

public class RacingGame {
    public void start(){
        InputView inputView = new InputView();
        int tryNumber = inputView.getTryNumber();
        List<Car> cars = inputView.getCars();

        Cars gameCars = new Cars(cars);

        System.out.println("실행 결과");
        for(int gameRound=0; gameRound < tryNumber; gameRound++){
            gameCars.raceOne();
            OutView.printRaceStatus(gameCars.getAllCars());
        }


    }
}
