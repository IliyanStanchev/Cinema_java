package services;

import dao.implementation.MovieDAO;
import entities.Movie;

import java.util.List;

public class MovieService {

    MovieDAO movieDAO = new MovieDAO();

    public Movie findById(int id) {

        return movieDAO.findById(id);
    }

    public Movie saveOrUpdate(Movie movie) {

        return movieDAO.saveOrUpdate(movie);
    }
}
