package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovieInDb(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirectorInDb(director);
    }

    public void addMovieDirectorPair(String movie,String director){
        movieRepository.addMoiveDirectorPairInDb(movie,director);
    }

    public Movie getMovie(String movie){
        return movieRepository.getMovieFromDm(movie);
    }

    public Director getDirector(String director){
        return movieRepository.getDirectorFromDb(director);
    }

    public List<String> getMovieDirector(String director){
        return movieRepository.getMovieByDirector(director);
    }

    public List<String> getallMovie(){
        return movieRepository.getAllMovie();
    }

    public void removeMovDir(String directorName){
        movieRepository.removeDirectorMovie(directorName);
    }

    public void deleteDirector(){
        movieRepository.deleteAllDirector();
    }


}
