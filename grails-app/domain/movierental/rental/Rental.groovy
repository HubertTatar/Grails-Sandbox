package movierental.rental

import grails.rest.Resource
import movierental.movie.Movie

@Resource(uri = '/rentals', readOnly = false, formats = ['json', 'xml'])
class Rental {
    String movie
    String user
}
