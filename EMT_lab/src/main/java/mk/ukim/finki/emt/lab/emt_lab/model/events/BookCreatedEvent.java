package mk.ukim.finki.emt.lab.emt_lab.model.events;

import org.springframework.context.ApplicationEvent;

public class BookCreatedEvent extends ApplicationEvent {
    public BookCreatedEvent(Object source) {
        super(source);
    }
}
