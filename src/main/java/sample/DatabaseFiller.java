package sample;

import dao.implementation.*;
import entities.*;
import enums.SeatState;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class DatabaseFiller {

    public void fillDatabase() {

        User user = new User("ench3r@gmail.com", "sach", "123", "Iliyan", "Stanchev", "0897875640");

        UserDAO userDAO = new UserDAO();

        user = userDAO.saveOrUpdate(user);

        GenreDAO genreDAO = new GenreDAO();

        Genre action = genreDAO.saveOrUpdate(new Genre("Action"));
        Genre comedy = genreDAO.saveOrUpdate(new Genre("Comedy"));
        Genre drama = genreDAO.saveOrUpdate(new Genre("Drama"));
        Genre fantasy = genreDAO.saveOrUpdate(new Genre("Fantasy"));

        AgeRestrictionDAO ageRestrictionDAO = new AgeRestrictionDAO();

        AgeRestriction ageRestrictionU = ageRestrictionDAO.saveOrUpdate(new AgeRestriction("No age restriction.",
                "src/main/resources/RestrictionImages/RestrictionU.png",
                0));
        AgeRestriction ageRestrictionPG = ageRestrictionDAO.saveOrUpdate(new AgeRestriction("Parental guidance only.",
                "src/main/resources/RestrictionImages/RestrictionPG.png",
                6));
        AgeRestriction ageRestrictionA = ageRestrictionDAO.saveOrUpdate(new AgeRestriction("Forbidden for teens under 12 years.",
                "src/main/resources/RestrictionImages/RestrictionA.png",
                12));
        AgeRestriction ageRestrictionR = ageRestrictionDAO.saveOrUpdate(new AgeRestriction("Forbidden for teens under 15 years.",
                "src/main/resources/RestrictionImages/RestrictionR.png",
                15));
        AgeRestriction ageRestrictionRPlus = ageRestrictionDAO.saveOrUpdate(new AgeRestriction("Forbidden for teens under 18 years.",
                "src/main/resources/RestrictionImages/RestrictionRPlus.png",
                18));

        MovieDimensionDAO movieDimensionDAO = new MovieDimensionDAO();

        MovieDimension movieDimension2D = movieDimensionDAO.saveOrUpdate(new MovieDimension("2D"));
        MovieDimension movieDimension3D = movieDimensionDAO.saveOrUpdate(new MovieDimension("3D"));
        MovieDimension movieDimension4D = movieDimensionDAO.saveOrUpdate(new MovieDimension("4D"));

        MovieDAO movieDAO = new MovieDAO();

        RatingDAO ratingDAO = new RatingDAO();

        Rating ratingGodzilla = ratingDAO.saveOrUpdate(new Rating(0, 0, 0));
        Rating ratingMortalKombat = ratingDAO.saveOrUpdate(new Rating(0, 0, 0));


        Movie godzillaVsKong = movieDAO.saveOrUpdate(new Movie(0,
                "Godzilla vs Kong",
                "'Godzilla vs. Kong' has gorgeous visuals, hard-hitting fights, and just enough plot to not overcomplicate the fun. [R]idiculously entertaining and endlessly rewatchable, at once funny and joyful yet also grounded and soulful.",
                action,
                ratingGodzilla,
                ageRestrictionU,
                "src/main/resources/MovieImages/Godzilla vs Kong.jpg"));


        Movie mortalKombat = movieDAO.saveOrUpdate(new Movie(0,
                "Mortal Kombat",
                "Cole trains with experienced warriors Liu Kang",
                action,
                ratingMortalKombat,
                ageRestrictionRPlus,
                "src/main/resources/MovieImages/Mortal Kombat.jpg"));

        ShowtimeDAO showtimeDAO = new ShowtimeDAO();

        Showtime showtimeGodzillaVsKong = showtimeDAO.saveOrUpdate(new Showtime(0,
                LocalDate.now(),
                LocalTime.of(12, 00, 00),
                LocalTime.of(14, 00, 00),
                12.50,
                godzillaVsKong,
                movieDimension3D));

        Showtime showtimeMortalKombat = showtimeDAO.saveOrUpdate(new Showtime(0,
                LocalDate.now(),
                LocalTime.of(14, 00, 00),
                LocalTime.of(16, 00, 00),
                10.50,
                mortalKombat,
                movieDimension4D));

        Showtime showtimeGodzillaVsKong2 = showtimeDAO.saveOrUpdate(new Showtime(0,
                LocalDate.now(),
                LocalTime.of(16, 00, 00),
                LocalTime.of(18, 00, 00),
                7.50,
                godzillaVsKong,
                movieDimension2D));

        RowDAO rowDAO = new RowDAO();

        Row row1 = rowDAO.saveOrUpdate(new Row(1, 8));
        Row row2 = rowDAO.saveOrUpdate(new Row(2, 8));
        Row row3 = rowDAO.saveOrUpdate(new Row(3, 8));

        SeatDAO seatDAO = new SeatDAO();
        seatDAO.saveOrUpdate(new Seat(1, row1));

        seatDAO.saveOrUpdate(new Seat(1, row1));
        seatDAO.saveOrUpdate(new Seat(2, row1));
        seatDAO.saveOrUpdate(new Seat(3, row1));
        seatDAO.saveOrUpdate(new Seat(4, row1));
        seatDAO.saveOrUpdate(new Seat(5, row1));
        seatDAO.saveOrUpdate(new Seat(6, row1));
        seatDAO.saveOrUpdate(new Seat(7, row1));
        seatDAO.saveOrUpdate(new Seat(8, row1));
        seatDAO.saveOrUpdate(new Seat(1, row2));
        seatDAO.saveOrUpdate(new Seat(2, row2));
        seatDAO.saveOrUpdate(new Seat(3, row2));
        seatDAO.saveOrUpdate(new Seat(4, row2));
        seatDAO.saveOrUpdate(new Seat(5, row2));
        seatDAO.saveOrUpdate(new Seat(6, row2));
        seatDAO.saveOrUpdate(new Seat(7, row2));
        seatDAO.saveOrUpdate(new Seat(8, row2));
        seatDAO.saveOrUpdate(new Seat(1, row3));
        seatDAO.saveOrUpdate(new Seat(2, row3));
        seatDAO.saveOrUpdate(new Seat(3, row3));
        seatDAO.saveOrUpdate(new Seat(4, row3));
        seatDAO.saveOrUpdate(new Seat(5, row3));
        seatDAO.saveOrUpdate(new Seat(6, row3));
        seatDAO.saveOrUpdate(new Seat(7, row3));
        seatDAO.saveOrUpdate(new Seat(8, row3));

        ArrayList<Seat> seats = (ArrayList<Seat>) seatDAO.getAll();

        ShowtimeSeatDAO showtimeSeatDAO = new ShowtimeSeatDAO();

        for (Seat seat : seats) {

            showtimeSeatDAO.saveOrUpdate(new ShowtimeSeat(0, showtimeGodzillaVsKong2, seat, SeatState.seatStateEmpty));
            showtimeSeatDAO.saveOrUpdate(new ShowtimeSeat(0, showtimeGodzillaVsKong, seat, SeatState.seatStateEmpty));
            showtimeSeatDAO.saveOrUpdate(new ShowtimeSeat(0, showtimeMortalKombat, seat, SeatState.seatStateEmpty));
        }

    }
}
