package todo_list.usecase.task.entity;

public class TaskEntity {
    private final String id;
    private final String title;
    private final String description;
    private final String establishmentDate;
    private final String reviseDate;
    private final boolean isCompletion;

    public TaskEntity(String id, String title, String description, String establishmentDate, String reviseDate, boolean isCompletion) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.establishmentDate = establishmentDate;
        this.reviseDate = reviseDate;
        this.isCompletion = isCompletion;
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
