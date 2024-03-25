package mk.ukim.finki.emt.lab.emt_lab.listeners;

import mk.ukim.finki.emt.lab.emt_lab.model.events.BookCreatedEvent;
import mk.ukim.finki.emt.lab.emt_lab.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {

    private final BookService bookService;

    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onProductCreated(BookCreatedEvent event) {
        this.bookService.refreshMaterializedView();
    }
}
