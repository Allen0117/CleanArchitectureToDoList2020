package todo_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo_list.usecase.task.create.CreateTaskUseCase;
import todo_list.usecase.task.get.GetAllTaskUseCase;
import todo_list.usecase.task.repository.ITaskRepository;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateTaskUseCase createTaskUseCase(ITaskRepository taskRepository) {
        return new CreateTaskUseCase(taskRepository);
    }

    @Bean
    public GetAllTaskUseCase getAllTaskUseCase(ITaskRepository taskRepository) {
        return new GetAllTaskUseCase(taskRepository);
    }
}
