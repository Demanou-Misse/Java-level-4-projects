package model;

public class Note<T extends Number> {
    private final Subject subject;
    private final T value;

    public Note(Subject subject, T value) {
        this.subject = subject;
        this.value = value;
    }

    public Subject getSubject() {
        return subject;
    }

    public T getValue() {
        return value;
    }
}

