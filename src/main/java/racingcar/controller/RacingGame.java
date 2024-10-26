package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.List;

public class RacingGame {
    public void start(){
        InputView inputView = new InputView();
        int tryNumber = inputView.getTryNumber();
        List<Car> cars = inputView.getCars();

    }
}
