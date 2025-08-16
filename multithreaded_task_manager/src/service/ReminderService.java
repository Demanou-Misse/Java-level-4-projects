package service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderService {

   private final ScheduledExecutorService scheduler;

   public ReminderService (int threadPoolSize) {
      this.scheduler = Executors.newScheduledThreadPool(threadPoolSize);
   }

   public void scheduleTask (Runnable task, long delay, TimeUnit unit) {
      scheduler.schedule(task, delay, unit);
   }

   public void shutdown() {
      scheduler.shutdown();
      try {
         if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
            scheduler.shutdownNow();
         }
      } catch (InterruptedException e) {
         scheduler.shutdownNow();
      }
   }

}
