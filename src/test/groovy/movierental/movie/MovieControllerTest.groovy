package movierental.movie

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MovieController)
@Mock([Movie, MovieType])
class MovieControllerTest extends Specification {

    def setup() {
        controller.movieService = Mock(MovieService)
        controller.movieService.findHorrors() >> {
            return [new Movie(title: "title", movieType: new MovieType(id: 1, type: "type"))]
        }
    }

    def "test horror"() {
        setup:
            request.method = "GET"
        when:
            controller.horror()
        then:
            response.status == 200
            response.json == [[movieType:[:], title:'title']]
    }
}
