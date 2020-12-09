package todo_list.usecase.task.repository;

import todo_list.usecase.task.entity.TaskEntity;

import java.util.List;

public interface ITaskRepository {
    void add(final TaskEntity taskEntity);

    TaskEntity findById(final String taskId);

    void save(final TaskEntity taskEntity);

    List<TaskEntity> findAll();
}
