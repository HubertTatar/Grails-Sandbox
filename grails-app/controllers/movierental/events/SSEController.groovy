package movierental.events

import grails.rx.web.RxController
import groovy.util.logging.Slf4j
import io.reactivex.Emitter
import io.reactivex.Observable

import java.util.concurrent.TimeUnit

@Slf4j
class SseController implements RxController {

    def events() {
        rx.stream { Emitter emitter ->
            try {
                Observable<Integer> ints = Observable.interval(1, TimeUnit.SECONDS)
                ints.subscribe {
                    s -> emitter.onNext(rx.render((s)))
                }
                emitter.onComplete()
            } catch (all) {
                emitter.onError(all)
            }
            emitter
        }
    }
}
