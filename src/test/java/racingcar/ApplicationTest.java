package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD,  // 첫 번째 라운드 전진
                MOVING_FORWARD, MOVING_FORWARD   // 두 번째 라운드도 모두 전진
        );
    }

    @Test
    void 빈_이름_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "1"))  // 빈 이름 포함
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤값에_따른_전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : -"); // 전진했는지 확인
                },
                MOVING_FORWARD  // 랜덤 값 4 이상 -> 전진
        );

        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output()).contains("pobi : "); // 멈췄는지 확인
                },
                STOP  // 랜덤 값 3 이하 -> 멈춤
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
