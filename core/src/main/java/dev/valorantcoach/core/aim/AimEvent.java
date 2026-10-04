package dev.valorantcoach.core.aim;

import java.util.List;
import java.util.Objects;

/**
 * One aim attempt: a target appears, the mouse moves towards it and the player clicks.
 *
 * <p>This is the raw data that all aim metrics (reaction time, flick accuracy,
 * micro-adjustments, ...) are calculated from. All timestamps use the same clock
 * and are measured in milliseconds.
 *
 * @param targetAppearedAtMs time at which the target became visible
 * @param targetPosition     centre of the target in pixels
 * @param targetRadius       radius of the target in pixels, must be positive
 * @param mousePath          mouse samples between the target appearing and the click,
 *                           ordered by time (copied defensively)
 * @param clickAtMs          time of the click, not before {@code targetAppearedAtMs}
 * @param clickPosition      mouse position at the moment of the click
 * @param hit                whether the click hit the target
 */
public record AimEvent(
        long targetAppearedAtMs,
        Vector2 targetPosition,
        double targetRadius,
        List<MouseSample> mousePath,
        long clickAtMs,
        Vector2 clickPosition,
        boolean hit) {

    /** Validates the values and makes the mouse path immutable. */
    public AimEvent {
        Objects.requireNonNull(targetPosition, "targetPosition must not be null");
        Objects.requireNonNull(mousePath, "mousePath must not be null");
        Objects.requireNonNull(clickPosition, "clickPosition must not be null");
        if (targetRadius <= 0) {
            throw new IllegalArgumentException("targetRadius must be positive");
        }
        if (clickAtMs < targetAppearedAtMs) {
            throw new IllegalArgumentException("click must not happen before the target appears");
        }
        mousePath = List.copyOf(mousePath);
        for (int i = 1; i < mousePath.size(); i++) {
            if (mousePath.get(i).timestampMs() < mousePath.get(i - 1).timestampMs()) {
                throw new IllegalArgumentException("mousePath must be ordered by time");
            }
        }
    }
}
