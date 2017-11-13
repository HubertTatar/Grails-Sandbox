package movierental.rental

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(RentalController)
@Mock(Rental)
class RentalControllerTest extends Specification {

    def setup() {
        controller.rentalService = Mock(RentalService)
    }

    def "list all"() {
        setup:
            request.method = 'GET'
        when:
            controller.rentalService.list() >> {
                return [new Rental(movie: 'movie',user: 'user')]
            }
            controller.list()
        then:
            response.status == 200
            response.json.result.size() == 1
    }
}
