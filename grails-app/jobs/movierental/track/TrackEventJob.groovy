package movierental.track

import grails.events.Event
import grails.events.annotation.Publisher
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

@Slf4j
@PackageScope
class TrackEventJob {

    static triggers = {
        simple name: 'oneSecTrigger', startDelay: 1000, repeatInterval: 1000
    }

    def execute() {
        log.info('TrackEventJob execute')
        Observable
                .interval(1, TimeUnit.SECONDS)
                .take(10)
                .subscribe({ l -> submitEvent(l)})
    }

    @Publisher('sseevent2')
    TrackStats submitEvent(Long l) {
        TrackStats stats = new TrackStats(info: "important info", status: l)
        return stats
    }

}
