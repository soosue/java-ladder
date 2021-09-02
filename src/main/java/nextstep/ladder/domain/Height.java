package nextstep.ladder.domain;

import java.util.stream.IntStream;

public class Height {

    private static final String LESS_THAN_ONE = "높이는 0보다 커야 합니다 -> %s";

    private final int height;

    public Height(final int height) {
        requireOverZero(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public IntStream intStream() {
        return IntStream.range(0, height);
    }

    private void requireOverZero(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format(LESS_THAN_ONE, number));
        }
    }

}