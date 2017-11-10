package movierental.user

import grails.rest.Resource

@Resource(uri = '/user', readOnly = false, formats = ['json', 'xml'])
class User {
    String login

    static constraints = {
        login nullable: false, empty: false
    }

    static mapping = {
        login unique: 'login'
    }
}
