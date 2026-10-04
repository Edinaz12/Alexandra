package dev.valorantcoach.core.aim;

import java.util.Objects;

/**
 * A single mouse position recorded at a point in time.
 *
 * @param timestampMs time of the sample in milliseconds
 * @param position    mouse position in pixels, must not be null
 */
public record MouseSample(long timestampMs, Vector2 position) {

    /** Validates that the position is present. */
    public MouseSample {
        Objects.requireNonNull(position, "position must not be null");
    }
}
