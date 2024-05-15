package roomescape.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import roomescape.model.Member;
import roomescape.model.Reservation;
import roomescape.model.ReservationTime;
import roomescape.model.Theme;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAll();

    Reservation save(Reservation reservation);

    List<Reservation> findByThemeAndMemberAndDateBetween(Theme theme, Member member, LocalDate dateFrom,
                                                         LocalDate dateTo);

    void deleteById(long id);

    long countById(long id);

    long countByTime(ReservationTime time);

    long countByDateAndTimeAndTheme(LocalDate date, ReservationTime time, Theme theme);

    List<Reservation> findAllByDateAndTheme(LocalDate date, Theme theme);
}
