package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void 유효한height로_Ladder생성() {
        new Ladder(2, 2);
    }

    @Test
    void play테스트() {
        Point point = Point.first(true);
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point.last());

        LadderLine ladderLine = new LadderLine(points);

        Ladder ladder = new Ladder(Arrays.asList(ladderLine));
        PlayResult playResult = ladder.play();

        assertThat(playResult.get(new Position(0))).isEqualTo(new Position(1));
        assertThat(playResult.get(new Position(1))).isEqualTo(new Position(0));
    }
}
