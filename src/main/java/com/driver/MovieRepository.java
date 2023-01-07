package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap = new HashMap<>();
    HashMap<String,Director> directorMap = new HashMap<>();
    HashMap<String,List<String>> movieDirectorMap = new HashMap<>();

    public void addMovieInDb(Movie movie){
        movieMap.put(movie.getName(),movie);
    }

    public void addDirectorInDb(Director director){
        directorMap.put(director.getName(), director);
    }

    public void addMoiveDirectorPairInDb(String movie, String director){
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();

            if(movieDirectorMap.containsKey(director))
                currentMoviesByDirector = movieDirectorMap.get(director);

            currentMoviesByDirector.add(movie);

            movieDirectorMap.put(director,currentMoviesByDirector);

        }
    }

    public Movie getMovieFromDm(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirectorFromDb(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> getMovieByDirector(String director){
        List<String> movieList = new ArrayList<>();
        return movieDirectorMap.get(director);
    }

    public List<String> getAllMovie(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void removeDirectorMovie(String name){
        if(movieDirectorMap.containsKey(name)) {
            List<String> findMovies = new ArrayList<>();
            findMovies = movieDirectorMap.get(name);
            for (String movie : findMovies) {
                movieMap.remove(movie);
            }
            movieDirectorMap.remove(name);
        }
        if (directorMap.containsKey(name))
            directorMap.remove(name);
    }

    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorMap = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: movieDirectorMap.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: movieDirectorMap.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        //clearing the pair.
        movieDirectorMap = new HashMap<>();
    }

}
