package com.stencil.merchant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.stencil.mbg.mapper.TaskMapper;
import com.chen.stencil.mbg.model.Task;
import com.stencil.merchant.dto.TaskParams;
import com.stencil.merchant.service.ITaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-21
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {


    @Autowired
    TaskMapper taskMapper;

    @Override
    public void CreateTask(TaskParams taskParams){

        Task task = new Task();
        BeanUtils.copyProperties(taskParams,task);

        task.setCreatedTime(LocalDateTime.now());
        task.setStatus(0);

        taskMapper.insert(task);

    }
}
