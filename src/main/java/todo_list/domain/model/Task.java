package todo_list.domain.model;

public class Task {
    private final String id;
    private String title;
    private String description;
    private final String establishmentDate;
    private String reviseDate;
    private boolean isCompletion;

    public Task(String id, String title, String description, String establishmentDate, String reviseDate, boolean isCompletion) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.establishmentDate = establishmentDate;
        this.reviseDate = reviseDate;
        this.isCompletion = isCompletion;
    }

    public void updateTitle(final String newTitle) {
        this.title = newTitle;
    }

    public void updateDescription(final String newDescription) {
        this.description = newDescription;
    }

    public void updateReviseDate(final String newReviseDate) {
        this.reviseDate = newReviseDate;
    }

    public void complete() {
        this.isCompletion = true;
    }

    public void unComplete() {
        this.isCompletion = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public String getReviseDate() {
        return reviseDate;
    }

    public boolean isCompletion() {
        return isCompletion;
    }
}
