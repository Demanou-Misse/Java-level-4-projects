package model;

import java.time.LocalDateTime;

public class LogEntry {

    private LocalDateTime dateTime;
    private String message;

    public LogEntry (LocalDateTime dateTime, String message) {
        this.dateTime = dateTime;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
