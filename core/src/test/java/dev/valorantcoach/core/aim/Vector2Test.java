package dev.valorantcoach.core.aim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Vector2Test {

    @Test
    void calculatesDistance() {
        Vector2 a = new Vector2(0, 0);
        Vector2 b = new Vector2(3, 4);

        assertEquals(5.0, a.distanceTo(b), 1e-9);
    }

    @Test
    void distanceToSelfIsZero() {
        Vector2 a = new Vector2(7, -2);

        assertEquals(0.0, a.distanceTo(a), 1e-9);
    }

    @Test
    void rejectsNullPoint() {
        assertThrows(NullPointerException.class, () -> new Vector2(1, 1).distanceTo(null));
    }
}
