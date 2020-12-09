package todo_list.usecase.task.get;

import todo_list.domain.usecase.Output;
import todo_list.usecase.task.dto.TaskDTO;

import java.util.List;

public interface GetAllTaskOutput extends Output {
    void setTaskDTOs(List<TaskDTO> taskDTOs);
}
