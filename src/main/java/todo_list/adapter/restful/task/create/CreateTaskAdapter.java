package todo_list.adapter.restful.task.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.adapter.restful.task.dto.TaskDTO;
import todo_list.usecase.task.create.CreateTaskInput;
import todo_list.usecase.task.create.CreateTaskUseCase;

@RestController
@RequestMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateTaskAdapter {

    @Autowired
    private CreateTaskUseCase createTaskUseCase;

    @PostMapping
    public ResponseEntity<CreateTaskViewModel> createBoard(@RequestBody TaskDTO createTaskInputBody) {
        CreateTaskInput createTaskInput = this.createTaskUseCase.createInput();
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();

        createTaskInput.setTaskTitle(createTaskInputBody.getTitle());
        createTaskInput.setTaskDescription(createTaskInputBody.getDescription());

        this.createTaskUseCase.execute(createTaskInput, createTaskPresenter);

        return ResponseEntity.ok().body(createTaskPresenter.buildCreateTaskViewModel());
    }
}
