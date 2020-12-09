package todo_list.usecase.task.mapper;

import todo_list.domain.model.Task;
import todo_list.usecase.task.entity.TaskEntity;

public class TaskEntityMapper {

    public static Task mappingTaskFrom(final TaskEntity taskEntity) {
        final String id = taskEntity.getId();
        final String title = taskEntity.getTitle();
        final String description = taskEntity.getDescription();
        final String establishmentDate = taskEntity.getEstablishmentDate();
        final String reviseDate = taskEntity.getReviseDate();
        final boolean isCompletion = taskEntity.isCompletion();

        return new Task(id, title, description, establishmentDate, reviseDate, isCompletion);
    }

    public static TaskEntity mappingTaskEntityFrom(final Task task) {
        final String id = task.getId();
        final String title = task.getTitle();
        final String description = task.getDescription();
        final String establishmentDate = task.getEstablishmentDate();
        final String reviseDate = task.getReviseDate();
        final boolean isCompletion = task.isCompletion();

        return new TaskEntity(id, title, description, establishmentDate, reviseDate, isCompletion);
    }
}
