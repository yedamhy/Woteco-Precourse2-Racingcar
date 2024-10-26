package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<Car> getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(",");
        validateCarsName(carNames);
        return Arrays.stream(carNames).map(Car::new).toList();
    }

    public int getTryNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            int tryNumber = Integer.parseInt(Console.readLine());
            validateTryNumber(tryNumber);
            return tryNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private void validateCarsName(String[] carNames){
        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("각 자동차의 이름은 5글자 이하로 지어주세요.");
            }
        }
    }

    private void validateTryNumber(int tryNumber){
        if(tryNumber < 0 || tryNumber > 10){
            throw new IllegalArgumentException("시도 횟수는 0이상 9이하로 설정해주세요.");
        }
    }
}
