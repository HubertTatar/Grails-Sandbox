package movierental.events

import grails.converters.JSON
import grails.events.Event
import grails.events.annotation.Subscriber
import grails.rx.web.RxController
import groovy.util.logging.Slf4j
import io.reactivex.Emitter
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

import java.util.concurrent.TimeUnit

@Slf4j
class SseController implements RxController {

    Subject subject = PublishSubject.create()
    Observable publishedObservable = subject.publish().autoConnect().observeOn(Schedulers.io())

    @Subscriber('sseevent')
    void myEventListener(Object data) {
        log.info("myEvent listener Thread ${Thread.currentThread().name}")
        subject.onNext(data)
    }

    def quartz() {
        rx.stream(
                publishedObservable
                    .doOnSubscribe { log.info("Quartz Subscribe Thread ${Thread.currentThread().name}") }
                    .map { Event event ->
                        rx.event ([event as JSON])
                    }
        )
    }

    def events() {
        Observable<Integer> ints = Observable.interval(1, TimeUnit.SECONDS)
        rx.stream { Emitter emitter ->
                ints.subscribe(
                        { s -> emitter.onNext(rx.render((s))) },
                        { ex -> emitter.onError(ex) },
                        { emitter.onComplete("Finished")} )
        }
    }

    def events2() {
        rx.stream (
            Observable
                .interval(1, TimeUnit.SECONDS)
                .map { rx.event([type: 'time', num: it as int] as JSON) }
        )
    }
}
