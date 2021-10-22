package com.chen.stencil.mbg.service.impl;

import com.chen.stencil.mbg.model.Task;
import com.chen.stencil.mbg.mapper.TaskMapper;
import com.chen.stencil.mbg.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2021-10-22
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
