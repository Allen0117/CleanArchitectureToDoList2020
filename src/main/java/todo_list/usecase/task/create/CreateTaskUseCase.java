package todo_list.usecase.task.create;

import todo_list.domain.common.DateProvider;
import todo_list.domain.common.UUIDGenerator;
import todo_list.domain.model.Task;
import todo_list.domain.usecase.UseCase;
import todo_list.usecase.task.entity.TaskEntity;
import todo_list.usecase.task.mapper.TaskEntityMapper;
import todo_list.usecase.task.repository.ITaskRepository;

public class CreateTaskUseCase implements UseCase<CreateTaskInput, CreateTaskOutput> {
    private final ITaskRepository taskRepository;

    public CreateTaskUseCase(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void execute(CreateTaskInput createTaskInput, CreateTaskOutput createTaskOutput) {
        final String id = UUIDGenerator.getID();
        final String title = createTaskInput.getTaskTitle();
        final String description = createTaskInput.getTaskDescription();
        final String establishmentDate = DateProvider.getCurrentDate();

        Task task = new Task(id, title, description, establishmentDate, establishmentDate, false);

        TaskEntity taskEntity = TaskEntityMapper.mappingTaskEntityFrom(task);

        this.taskRepository.add(taskEntity);

        createTaskOutput.setTaskId(id);
        createTaskOutput.setTaskTitle(title);
        createTaskOutput.setTaskDescription(description);
        createTaskOutput.setTaskEstablishmentDate(establishmentDate);
        createTaskOutput.setTaskReviseDate(establishmentDate);
        createTaskOutput.setTaskIsCompletion(false);
    }

    @Override
    public CreateTaskInput createInput() {
        return new CreateTaskInputImpl();
    }

    private static class CreateTaskInputImpl implements CreateTaskInput {
        private String taskTitle;
        private String taskDescription;

        @Override
        public void setTaskTitle(String taskTitle) {
            this.taskTitle = taskTitle;
        }

        @Override
        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        @Override
        public String getTaskTitle() {
            return this.taskTitle;
        }

        @Override
        public String getTaskDescription() {
            return this.taskDescription;
        }
    }
}
