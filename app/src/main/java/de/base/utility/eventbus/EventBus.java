package de.base.utility.eventbus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import de.base.utility.eventbus.events.Event;

/**
 * Created by scorp on 16.03.2017.
 */

public class EventBus {

    private final PublishSubject<Event> bus = PublishSubject.create();

    public <T> Disposable register(final Class<T> eventClass, Consumer<T> onNext) {
        return bus
                .observeOn(AndroidSchedulers.mainThread())
                .filter(event -> event.getClass().equals(eventClass))
                .map(obj -> (T) obj)
                .subscribe(onNext);
    }

    public void post(Event event){
        bus.onNext(event);
    }
}
