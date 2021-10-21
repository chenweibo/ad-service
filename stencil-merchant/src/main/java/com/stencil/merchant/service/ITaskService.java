package com.stencil.merchant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.stencil.mbg.model.Task;
import com.stencil.merchant.domain.MyPage;
import com.stencil.merchant.dto.TaskParams;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2021-10-21
 */
public interface ITaskService extends IService<Task> {

    @Transactional
    void CreateTask(TaskParams taskParams);

}
