package todo_list.usecase.task.create;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import todo_list.adapter.presenter.task.create.CreateTaskPresenter;
import todo_list.adapter.presenter.task.viewmodel.CreateTaskViewModel;
import todo_list.adapter.repository.task.InMemoryTaskRepository;
import todo_list.domain.model.Task;
import todo_list.usecase.task.entity.TaskEntity;
import todo_list.usecase.task.mapper.TaskEntityMapper;
import todo_list.usecase.task.repository.ITaskRepository;

public class CreateTaskUseCaseTest {
    private ITaskRepository taskRepository;

    @Before
    public void setUp() {
        this.taskRepository = new InMemoryTaskRepository();
    }

    @Test
    public void test_create_task_use_case() {
        Assert.assertEquals(0, this.taskRepository.findAll().size());

        CreateTaskUseCase createTaskUseCase = new CreateTaskUseCase(this.taskRepository);

        CreateTaskInput createTaskInput = createTaskUseCase.createInput();
        createTaskInput.setTaskTitle("createTaskUseCase");
        createTaskInput.setTaskDescription("Use TDD develop todo_list");
        CreateTaskPresenter createTaskPresenter = new CreateTaskPresenter();

        createTaskUseCase.execute(createTaskInput, createTaskPresenter);

        CreateTaskViewModel createTaskViewModel = createTaskPresenter.buildCreateTaskViewModel();

        TaskEntity taskEntity = this.taskRepository.findById(createTaskViewModel.getTaskId());
        Task task = TaskEntityMapper.mappingTaskFrom(taskEntity);


        Assert.assertEquals(1, this.taskRepository.findAll().size());
        Assert.assertEquals(createTaskViewModel.getTaskId(), task.getId());
        Assert.assertEquals(createTaskViewModel.getTaskTitle(), task.getTitle());
        Assert.assertEquals(createTaskViewModel.getTaskDescription(), task.getDescription());
        Assert.assertEquals(createTaskViewModel.getTaskEstablishmentDate(), task.getEstablishmentDate());
        Assert.assertEquals(createTaskViewModel.getTaskReviseDate(), task.getReviseDate());
        Assert.assertEquals(createTaskViewModel.isTaskIsCompletion(), task.isCompletion());
    }
}
