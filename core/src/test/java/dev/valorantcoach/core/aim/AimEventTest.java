package dev.valorantcoach.core.aim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AimEventTest {

    private static final Vector2 TARGET = new Vector2(100, 100);
    private static final Vector2 CLICK = new Vector2(102, 99);

    @Test
    void rejectsClickBeforeTargetAppears() {
        assertThrows(IllegalArgumentException.class,
                () -> new AimEvent(1000, TARGET, 20, List.of(), 900, CLICK, false));
    }

    @Test
    void rejectsNonPositiveRadius() {
        assertThrows(IllegalArgumentException.class,
                () -> new AimEvent(1000, TARGET, 0, List.of(), 1200, CLICK, true));
    }

    @Test
    void rejectsUnorderedMousePath() {
        List<MouseSample> path = List.of(
                new MouseSample(1100, new Vector2(10, 10)),
                new MouseSample(1050, new Vector2(20, 20)));
        assertThrows(IllegalArgumentException.class,
                () -> new AimEvent(1000, TARGET, 20, path, 1200, CLICK, true));
    }

    @Test
    void copiesMousePathDefensively() {
        List<MouseSample> path = new ArrayList<>();
        path.add(new MouseSample(1050, new Vector2(10, 10)));
        AimEvent event = new AimEvent(1000, TARGET, 20, path, 1200, CLICK, true);

        path.add(new MouseSample(1100, new Vector2(20, 20)));

        assertEquals(1, event.mousePath().size());
    }
}
