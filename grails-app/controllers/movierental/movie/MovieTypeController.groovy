package movierental.movie


import grails.rest.*
import grails.converters.*

class MovieTypeController extends RestfulController {
    static responseFormats = ['json', 'xml']
    MovieTypeController() {
        super(MovieType)
    }
}
