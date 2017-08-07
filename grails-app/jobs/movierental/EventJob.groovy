package movierental

import grails.events.annotation.Publisher
import groovy.util.logging.Slf4j

@Slf4j
class EventJob {

    static final String JOB_GENERATED_EVENT = "JOB_GENERATED_EVENT"
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
