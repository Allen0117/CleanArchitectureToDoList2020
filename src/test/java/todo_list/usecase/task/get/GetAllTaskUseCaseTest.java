package todo_list.usecase.task.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.adapter.presenter.task.get.GetAllTasksPresenter;
import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.adapter.presenter.task.viewmodel.GetAllTasksViewModel;
import todo_list.adapter.repository.task.InMemoryTaskRepository;
import todo_list.domain.model.Task;
import todo_list.usecase.task.create.CreateTaskInput;
import todo_list.usecase.task.create.CreateTaskUseCase;
import todo_list.usecase.task.entity.TaskEntity;
import todo_list.usecase.task.mapper.TaskEntityMapper;
import todo_list.usecase.task.repository.ITaskRepository;
import todo_list.usecase.task.util.Utility;

import java.util.List;

public class GetAllTaskUseCaseTest {
    private ITaskRepository taskRepository;
    private Utility utility;

    @Before
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
        this.utility = new Utility(this.taskRepository);
    }

    @Test
    public void test_get_all_task_use_case() {
        Assert.assertEquals(0, this.taskRepository.findAll().size());

        createTask("createTaskUseCase", "Use TDD develop todo_list");
        createTask("getAllTasksUseCase", "Use Clean Architecture develop todo_list");

        Assert.assertEquals(2, this.taskRepository.findAll().size());

        GetAllTaskUseCase getAllTaskUseCase = new GetAllTaskUseCase(this.taskRepository);
        GetAllTaskInput getAllTaskInput = getAllTaskUseCase.createInput();
        GetAllTasksPresenter getAllTasksPresenter = new GetAllTasksPresenter();

        getAllTaskUseCase.execute(getAllTaskInput, getAllTasksPresenter);

        List<GetAllTasksViewModel> getAllTasksViewModels = getAllTasksPresenter.buildGetAllTasksTaskViewModel();

        Assert.assertEquals(2, getAllTasksViewModels.size());

        Task firstTask = getTask(getAllTasksViewModels.get(0).getTaskId());
        Task secondTask = getTask(getAllTasksViewModels.get(1).getTaskId());

        Assert.assertEquals("createTaskUseCase", firstTask.getTitle());
        Assert.assertEquals("Use TDD develop todo_list", firstTask.getDescription());
        Assert.assertEquals("getAllTasksUseCase", secondTask.getTitle());
        Assert.assertEquals("Use Clean Architecture develop todo_list", secondTask.getDescription());
    }

    private void createTask(final String taskTitle, final String taskDescription) {
        this.utility.createTask(taskTitle, taskDescription);
    }

    private Task getTask(final String taskId) {
        return this.utility.getTask(taskId);
    }
}
