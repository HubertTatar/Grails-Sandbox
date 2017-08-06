package movierental

import groovy.util.logging.Slf4j
import movierental.movie.Movie
import movierental.movie.MovieType

@Slf4j
class BootStrap {

    def init = { servletContext ->
      log.info("Bootstraping data")
        MovieType type = new MovieType(type: 'horror').save()
        10.times {
            Movie movie = new Movie(title: "mov${it}", movieType: type).save()
            log.info("saving $movie.title")
        }
    }
    def destroy = {
    }
}
