package movierental

import groovy.util.logging.Slf4j
import movierental.movie.Movie
import movierental.movie.MovieType
import movierental.rental.Rental

@Slf4j
class BootStrap {

    def init = { servletContext ->
      log.info("Bootstraping data")
        MovieType type = new MovieType(type: 'horror').save()
        10.times {
            Movie movie = new Movie(title: "mov${it}", movieType: type).save()
            log.info("saving $movie.title")
        }

        10.times {
            Rental rental = new Rental(movie: "mov${it}", user: "user${it}").save()
            log.info("saving $rental.movie")
        }
    }
    def destroy = {
    }
}
