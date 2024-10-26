package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<Car> getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");

        return Arrays.stream(carNames).map(Car::new).toList();
    }
}
