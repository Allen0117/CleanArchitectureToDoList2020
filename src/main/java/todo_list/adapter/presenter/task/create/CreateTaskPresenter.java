package todo_list.adapter.presenter.task.create;

import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.usecase.task.create.CreateTaskOutput;

public class CreateTaskPresenter implements CreateTaskOutput {
    private String taskId;
    private String taskTitle;
    private String taskDescription;
    private String taskEstablishmentDate;
    private String taskReviseDate;
    private boolean taskIsCompletion;

    @Override
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Override
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public void setTaskEstablishmentDate(String taskEstablishmentDate) {
        this.taskEstablishmentDate = taskEstablishmentDate;
    }

    @Override
    public void setTaskReviseDate(String taskReviseDate) {
        this.taskReviseDate = taskReviseDate;
    }

    @Override
    public void setTaskIsCompletion(boolean taskIsCompletion) {
        this.taskIsCompletion = taskIsCompletion;
    }

    public CreateTaskViewModel buildCreateTaskViewModel() {
        CreateTaskViewModel createTaskViewModel = new CreateTaskViewModel();
        createTaskViewModel.setTaskId(this.taskId);
        createTaskViewModel.setTaskTitle(this.taskTitle);
        createTaskViewModel.setTaskDescription(this.taskDescription);
        createTaskViewModel.setTaskEstablishmentDate(this.taskEstablishmentDate);
        createTaskViewModel.setTaskReviseDate(this.taskReviseDate);
        createTaskViewModel.setTaskIsCompletion(this.taskIsCompletion);

        return createTaskViewModel;
    }
}
