package movierental.rental

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import movierental.Application
import spock.lang.Shared


@Integration(applicationClass = Application)
@Rollback
class RentalControllerSpecification extends BaseSpec {

    @Shared RestBuilder rest = new RestBuilder()

    def "list all"() {
        when:
            RestResponse resp = get(rest, 'rental', null)
        then:
            resp.status == 200
            resp.json.result.size() == 10
    }

    def "create"() {
        when:
            Map<String, String> map = [
                    'movie': 'test',
                    'user': 'test'
            ]
            RestResponse resp = post(rest, 'rental', null, map)
        then:
            resp.status == 200
    }
}
