package dev.valorantcoach.core.aim;

import java.util.Objects;

/**
 * A point or direction in 2D screen space, measured in pixels.
 *
 * @param x horizontal position in pixels
 * @param y vertical position in pixels
 */
public record Vector2(double x, double y) {

    /**
     * Returns the straight-line distance from this point to another point.
     *
     * @param other the other point, must not be null
     * @return the distance in pixels
     */
    public double distanceTo(Vector2 other) {
        Objects.requireNonNull(other, "other must not be null");
        return Math.hypot(x - other.x, y - other.y);
    }
}
