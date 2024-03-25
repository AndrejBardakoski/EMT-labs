package mk.ukim.finki.emt.lab.emt_lab.jobs;

import mk.ukim.finki.emt.lab.emt_lab.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private final BookService bookService;

    public Scheduler(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(fixedDelay = 5000)
    public void refreshMaterializedView() {
        this.bookService.refreshMaterializedView();
    }

}
