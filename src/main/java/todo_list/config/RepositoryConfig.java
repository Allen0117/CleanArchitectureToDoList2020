package todo_list.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo_list.adapter.repository.task.InMemoryTaskRepository;
import todo_list.usecase.task.repository.ITaskRepository;

@Configuration
public class RepositoryConfig {

    @Bean
    public ITaskRepository createInMemoryTaskRepository() {
        return new InMemoryTaskRepository();
    }
}
