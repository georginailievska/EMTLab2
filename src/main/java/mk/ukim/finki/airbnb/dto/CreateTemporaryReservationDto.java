package mk.ukim.finki.airbnb.dto;

import mk.ukim.finki.airbnb.model.domain.Accommodation;
import mk.ukim.finki.airbnb.model.domain.TemporaryReservation;
import mk.ukim.finki.airbnb.model.domain.User;

public record CreateTemporaryReservationDto(
        Long userId,
        Long accommodationId,
        boolean confirmed
) {
    public TemporaryReservation toReservation(User user, Accommodation accommodation) {
        return new TemporaryReservation(user, accommodation, confirmed);
    }
}
