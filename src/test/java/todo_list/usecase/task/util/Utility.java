package todo_list.usecase.task.util;

import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.domain.model.Task;
import todo_list.usecase.task.create.CreateTaskInput;
import todo_list.usecase.task.create.CreateTaskUseCase;
import todo_list.usecase.task.entity.TaskEntity;
import todo_list.usecase.task.mapper.TaskEntityMapper;
import todo_list.usecase.task.repository.ITaskRepository;

public class Utility {
    private final ITaskRepository taskRepository;

    public Utility(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(final String taskTitle, final String taskDescription) {
        CreateTaskUseCase createTaskUseCase = new CreateTaskUseCase(this.taskRepository);
        CreateTaskInput createTaskInput = createTaskUseCase.createInput();

        createTaskInput.setTaskTitle(taskTitle);
        createTaskInput.setTaskDescription(taskDescription);

        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();

        createTaskUseCase.execute(createTaskInput, createTaskPresenter);
    }

    public Task getTask(final String taskId) {
        TaskEntity taskEntity = this.taskRepository.findById(taskId);

        Task task = TaskEntityMapper.mappingTaskFrom(taskEntity);

        return task;
    }
}
