package movierental

import grails.events.annotation.Publisher
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j

@Slf4j
@PackageScope
class EventJob {

    Random rand = new Random()

    static triggers = {
        simple name: 'oneSecTrigger', startDelay: 1000, repeatInterval: 1000
    }

    @Publisher('sseevent')
    def execute() {
        log.info("Executing")
        rand.nextInt(100)
    }
}
