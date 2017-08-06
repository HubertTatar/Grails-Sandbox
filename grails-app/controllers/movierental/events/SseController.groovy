package movierental.events

import grails.rx.web.RxController
import groovy.util.logging.Slf4j
import io.reactivex.Emitter
import io.reactivex.Observable

import java.util.concurrent.TimeUnit

@Slf4j
class SseController implements RxController {

    def events() {
        Observable<Integer> ints = Observable.interval(1, TimeUnit.SECONDS)
        rx.stream { Emitter emitter ->
                ints.subscribe(
                        { s -> emitter.onNext(rx.render((s))) },
                        { ex -> emitter.onError(ex) },
                        { emitter.onComplete("Finished")} )
        }
    }
}
