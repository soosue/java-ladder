package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    public static final String INVALID_WIDTH_HEIGHT_MESSAGE = "width와 height는 양수여야 합니다.";

    private static final int MIN_WIDTH = 1;
    private static final int MIN_HEIGHT = 1;
    public static final int INDEX_ZERO = 0;

    private final List<Line> lines;

    public Ladder(Names names, int height) {
        this(widthFromNames(names), height);
    }

    private static int widthFromNames(Names names) {
        return names.count() * 2 - 1;
    }

    public Ladder(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_WIDTH_HEIGHT_MESSAGE);
        }

        this.lines = IntStream.range(INDEX_ZERO, height)
                .mapToObj(index -> new Line(width))
                .collect(Collectors.toList());
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        return lines.get(INDEX_ZERO).width();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
