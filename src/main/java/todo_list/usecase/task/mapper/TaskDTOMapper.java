package todo_list.usecase.task.mapper;

import todo_list.domain.model.Task;
import todo_list.usecase.task.dto.TaskDTO;

public class TaskDTOMapper {

    public static TaskDTO mappingTaskDTOFrom(final Task task) {
        final String id = task.getId();
        final String title = task.getTitle();
        final String description = task.getDescription();
        final String establishmentDate = task.getEstablishmentDate();
        final String reviseDate = task.getReviseDate();
        final boolean isCompletion = task.isCompletion();

        return new TaskDTO(id, title, description, establishmentDate, reviseDate, isCompletion);
    }
}
