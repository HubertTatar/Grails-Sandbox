package movierental.movie

import grails.gorm.services.Service
import groovy.transform.PackageScope

@Service(Movie)
@PackageScope
interface MovieDbService {
    List<Movie> findAllByMovieType(MovieType movieType)
}