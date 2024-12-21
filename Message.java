import java.time.LocalDate;

class Message {
    private String title;
    private EmergencyLevel importanceLevel;
    private String message;
    private LocalDate date;

    public Message(String title, EmergencyLevel importanceLevel, String message, LocalDate date) {
        this.title = title;
        this.importanceLevel = importanceLevel;
        this.message = message;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public EmergencyLevel getImportanceLevel() {
        return importanceLevel;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" + "title='" + title + '\'' + ", importanceLevel=" + importanceLevel + ", message='" + message + '\'' + ", date=" + date + '}';
    }
}