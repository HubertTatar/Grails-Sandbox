package movierental.rental

import grails.validation.Validateable

class UpdateCommand implements Validateable {
    String movie
    String user

    static constraints = {
        movie nullable: true
        user nullable: true
    }
}
