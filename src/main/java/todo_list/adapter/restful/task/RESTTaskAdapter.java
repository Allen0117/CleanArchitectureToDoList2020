package todo_list.adapter.restful.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.adapter.presenter.task.get.GetAllTasksPresenter;
import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.adapter.presenter.task.viewmodel.GetAllTasksViewModel;
import todo_list.adapter.restful.task.dto.TaskInputDTO;
import todo_list.usecase.task.create.CreateTaskInput;
import todo_list.usecase.task.create.CreateTaskUseCase;
import todo_list.usecase.task.get.GetAllTaskInput;
import todo_list.usecase.task.get.GetAllTaskUseCase;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class RESTTaskAdapter {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;
    @Autowired
    private GetAllTaskUseCase getAllTaskUseCase;


    @GetMapping
    public ResponseEntity<List<GetAllTasksViewModel>> getAllTask() {
        GetAllTaskInput getAllTaskInput = this.getAllTaskUseCase.createInput();
        GetAllTasksPresenter getAllTasksPresenter = new GetAllTasksPresenter();

        this.getAllTaskUseCase.execute(getAllTaskInput, getAllTasksPresenter);

        return ResponseEntity.ok().body(getAllTasksPresenter.buildGetAllTasksTaskViewModel());
    }

    @PostMapping
    public ResponseEntity<CreateTaskViewModel> createTask(@RequestBody TaskInputDTO createTaskInputBody) {
        CreateTaskInput createTaskInput = this.createTaskUseCase.createInput();
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();

        createTaskInput.setTaskTitle(createTaskInputBody.getTitle());
        createTaskInput.setTaskDescription(createTaskInputBody.getDescription());

        this.createTaskUseCase.execute(createTaskInput, createTaskPresenter);

        return ResponseEntity.ok().body(createTaskPresenter.buildCreateTaskViewModel());
    }
}
