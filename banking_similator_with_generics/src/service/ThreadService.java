package service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadService {

    private ExecutorService service;

    public ThreadService (int threadPoolSize) {
        this.service = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void submit(Runnable task) {
        service.submit(task);
    }

    public void shutdown() {
        service.shutdown();
        try {
            if (!service.awaitTermination(5, TimeUnit.SECONDS)) service.shutdownNow();
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }

}
