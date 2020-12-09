package todo_list.usecase.task.get;

import todo_list.domain.usecase.UseCase;
import todo_list.usecase.task.dto.TaskDTO;
import todo_list.usecase.task.mapper.TaskDTOMapper;
import todo_list.usecase.task.mapper.TaskEntityMapper;
import todo_list.usecase.task.repository.ITaskRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllTaskUseCase implements UseCase<GetAllTaskInput, GetAllTaskOutput> {
    private final ITaskRepository taskRepository;

    public GetAllTaskUseCase(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void execute(GetAllTaskInput getAllTaskInput, GetAllTaskOutput getAllTaskOutput) {
        List<TaskDTO> taskDTOS = this.taskRepository.findAll()
                                                    .stream()
                                                    .map(TaskEntityMapper::mappingTaskFrom)
                                                    .map(TaskDTOMapper::mappingTaskDTOFrom)
                                                    .collect(Collectors.toList());

        getAllTaskOutput.setTaskDTOs(taskDTOS);
    }

    @Override
    public GetAllTaskInput createInput() {
        return new GetAllTaskInputImpl();
    }

    private static class GetAllTaskInputImpl implements GetAllTaskInput {

    }
}
