package movierental.movie


import grails.rest.*

@Resource(uri = '/movieTypes', readOnly = false, formats = ['json', 'xml'])
class MovieType {
    String type
}