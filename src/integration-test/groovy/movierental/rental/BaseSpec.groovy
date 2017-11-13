package movierental.rental

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import spock.lang.Specification

class BaseSpec extends Specification {

    protected RestResponse get(RestBuilder rest, String urlPart, String token) {
        return rest.get("http://localhost:${serverPort}/${urlPart}") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            if (token) {
                header("Authorization", "Bearer ${token}")
            }
        }
    }

    protected RestResponse post(RestBuilder rest, String urlPart, String token, Map<String, Object> map) {
        return rest.post("http://localhost:${serverPort}/${urlPart}") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            if (token) {
                header("Authorization", "Bearer ${token}")
            }
            json(map)
        }
    }
}
