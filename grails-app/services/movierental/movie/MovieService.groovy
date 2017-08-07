package movierental.movie

import groovy.transform.PackageScope
import org.springframework.transaction.annotation.Transactional

@Transactional
@PackageScope
class MovieService {

    MovieDbService movieDbService

    List<Movie> findHorrors() {
        movieDbService.findAllByMovieType(MovieType.findByType('horror'))
    }
}
