package todo_list.adapter.presenter.task.viewmodel;

public class CreateTaskViewModel {
    private String taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskEstablishmentDate;
    private String taskReviseDate;
    private boolean taskIsCompletion;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskEstablishmentDate() {
        return taskEstablishmentDate;
    }

    public void setTaskEstablishmentDate(String taskEstablishmentDate) {
        this.taskEstablishmentDate = taskEstablishmentDate;
    }

    public String getTaskReviseDate() {
        return taskReviseDate;
    }

    public void setTaskReviseDate(String taskReviseDate) {
        this.taskReviseDate = taskReviseDate;
    }

    public boolean isTaskIsCompletion() {
        return taskIsCompletion;
    }

    public void setTaskIsCompletion(boolean taskIsCompletion) {
        this.taskIsCompletion = taskIsCompletion;
    }
}
