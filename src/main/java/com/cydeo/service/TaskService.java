package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.CrudService;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long> {

    List<TaskDTO> findTaskByManager(UserDTO manager);
    List<TaskDTO> findAllTaskByStatus(Status status);
    List<TaskDTO> findAllTaskByStatusIsNot(Status status);

    void  updateStatus(TaskDTO task);
}
