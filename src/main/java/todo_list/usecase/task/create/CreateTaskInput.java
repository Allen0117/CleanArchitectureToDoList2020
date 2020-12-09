package todo_list.usecase.task.create;

import todo_list.domain.usecase.Input;

public interface CreateTaskInput extends Input {
    void setTaskTitle(final String taskTitle);
    void setTaskDescription(final String taskDescription);
    String getTaskTitle();
    String getTaskDescription();
}
