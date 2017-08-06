package movierental.movie


import grails.rest.*

@Resource(uri = '/movies', readOnly = false, formats = ['json', 'xml'])
class Movie {
    String title
    MovieType movieType
}