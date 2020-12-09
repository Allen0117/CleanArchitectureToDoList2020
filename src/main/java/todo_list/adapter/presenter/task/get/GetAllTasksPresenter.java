package todo_list.adapter.presenter.task.get;

import todo_list.adapter.presenter.task.viewmodel.GetAllTasksViewModel;
import todo_list.usecase.task.dto.TaskDTO;
import todo_list.usecase.task.get.GetAllTaskOutput;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllTasksPresenter implements GetAllTaskOutput {
    private List<TaskDTO> taskDTOS;

    @Override
    public void setTaskDTOs(final List<TaskDTO> taskDTOS) {
        this.taskDTOS = taskDTOS;
    }

    public List<GetAllTasksViewModel> buildGetAllTasksTaskViewModel() {
        return this.taskDTOS.stream().map(this::mappingTaskDTOToGetAllTasksTaskViewModel).collect(Collectors.toList());
    }

    private GetAllTasksViewModel mappingTaskDTOToGetAllTasksTaskViewModel(TaskDTO taskDTO){
        GetAllTasksViewModel getAllTasksViewModel = new GetAllTasksViewModel();
        getAllTasksViewModel.setTaskId(taskDTO.getId());
        getAllTasksViewModel.setTaskTitle(taskDTO.getTitle());
        getAllTasksViewModel.setTaskDescription(taskDTO.getDescription());
        getAllTasksViewModel.setTaskEstablishmentDate(taskDTO.getEstablishmentDate());
        getAllTasksViewModel.setTaskReviseDate(taskDTO.getReviseDate());
        getAllTasksViewModel.setTaskIsCompletion(taskDTO.isCompletion());

        return getAllTasksViewModel;
    }
}
