package todo_list.usecase.task.create;

import todo_list.domain.usecase.Output;

public interface CreateTaskOutput extends Output {
    void setTaskId(final String taskId);
    void setTaskTitle(final String taskTitle);
    void setTaskDescription(final String taskDescription);
    void setTaskEstablishmentDate(final String taskEstablishmentDate);
    void setTaskReviseDate(final String taskReviseDate);
    void setTaskIsCompletion(final boolean taskIsCompletion);
}
