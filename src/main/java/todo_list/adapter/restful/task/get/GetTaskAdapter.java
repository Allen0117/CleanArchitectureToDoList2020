package todo_list.adapter.restful.task.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.adapter.presenter.task.get.GetAllTasksPresenter;
import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.adapter.presenter.task.viewmodel.GetAllTasksViewModel;
import todo_list.adapter.restful.task.dto.TaskDTO;
import todo_list.usecase.task.create.CreateTaskInput;
import todo_list.usecase.task.get.GetAllTaskInput;
import todo_list.usecase.task.get.GetAllTaskUseCase;

import java.util.List;

@RestController
@RequestMapping(value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetTaskAdapter {

    @Autowired
    private GetAllTaskUseCase getAllTaskUseCase;

    @GetMapping
    public ResponseEntity<List<GetAllTasksViewModel>> getAllTask() {
        GetAllTaskInput getAllTaskInput = this.getAllTaskUseCase.createInput();
        GetAllTasksPresenter getAllTasksPresenter = new GetAllTasksPresenter();

        this.getAllTaskUseCase.execute(getAllTaskInput, getAllTasksPresenter);

        return ResponseEntity.ok().body(getAllTasksPresenter.buildGetAllTasksTaskViewModel());
    }
}
