package movierental.rental

import grails.validation.Validateable

class GetCommand implements Validateable {
    Serializable id

    static constraints = {
        id nullable: true
    }
}
