package movierental.movie


import grails.rest.*
import grails.converters.*
import io.swagger.annotations.Api

@Api(value = "movie", description = "Rest Endpoint for Movie")
class MovieController extends RestfulController {
    static responseFormats = ['json', 'xml']

    MovieService movieService

    MovieController() {
        super(Movie)
    }

    def horror() {
        respond movieService.findHorrors()
    }
}
