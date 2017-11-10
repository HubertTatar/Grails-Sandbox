package movierental.rental

import grails.validation.Validateable

class CreateCommand implements Validateable {
    String movie
    String user

    static constraints = {
        movie nullable: true
        user nullable: true
    }
}
