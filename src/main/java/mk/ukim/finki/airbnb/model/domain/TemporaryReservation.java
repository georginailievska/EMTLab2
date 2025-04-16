package mk.ukim.finki.airbnb.model.domain;

import jakarta.persistence.*;

@Entity
public class TemporaryReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accommodation accommodation;

    private boolean confirmed;

    public TemporaryReservation() {}

    public TemporaryReservation(User user, Accommodation accommodation) {
        this.user = user;
        this.accommodation = accommodation;
        this.confirmed = false;
    }

    public TemporaryReservation(User user, Accommodation accommodation, boolean confirmed) {
        this.user = user;
        this.accommodation = accommodation;
        this.confirmed = confirmed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
