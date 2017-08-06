package movierental.movie


import grails.rest.*
import grails.converters.*

class MovieController extends RestfulController {
    static responseFormats = ['json', 'xml']
    MovieController() {
        super(Movie)
    }

    def horror() {
        respond.hal Movie.findAllByMovieType(MovieType.findByType('horror'))
    }
}
