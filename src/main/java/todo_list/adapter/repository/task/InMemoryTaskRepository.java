package todo_list.adapter.repository.task;

import todo_list.usecase.task.entity.TaskEntity;
import todo_list.usecase.task.repository.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InMemoryTaskRepository implements ITaskRepository {
    private final List<TaskEntity> taskEntities;

    public InMemoryTaskRepository() {
        this.taskEntities = new ArrayList<>();
    }

    @Override
    public void add(final TaskEntity taskEntity) {
        this.taskEntities.add(taskEntity);
    }

    @Override
    public TaskEntity findById(final String taskId) {
        return this.taskEntities.stream()
                .filter(findTaskById(taskId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    private static Predicate<TaskEntity> findTaskById(final String taskId){
        return task -> task.getId().equals(taskId);
    }

    @Override
    public void save(final TaskEntity taskEntity) {
        for (TaskEntity each : this.taskEntities){
            if (each.getId().equals(taskEntity.getId()))
                this.taskEntities.set(this.taskEntities.indexOf(each), taskEntity);
        }
    }

    @Override
    public List<TaskEntity> findAll() {
        return this.taskEntities;
    }
}
