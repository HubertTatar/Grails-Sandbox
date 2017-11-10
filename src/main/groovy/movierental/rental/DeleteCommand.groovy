package movierental.rental

import grails.validation.Validateable

class DeleteCommand implements Validateable {
    Serializable id

    static constraints = {
        id nullable: true
    }
}
