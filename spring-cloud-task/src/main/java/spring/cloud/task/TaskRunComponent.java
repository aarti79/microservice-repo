package spring.cloud.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class TaskRunComponent {

 

	private static final Log logger = LogFactory.getLog(TaskRunComponent.class);

 

    @Autowired
    private TaskRunRepository taskRunRepository;

 

    @BeforeTask
    public void init(TaskExecution taskExecution) {
        String execDate = new SimpleDateFormat().format(new Date());
        this.taskRunRepository.save(new TaskRunOutput("Executed at " + execDate));
        logger.info("Executed at : " + execDate);
    }
    
    @AfterTask
    public void aftertask(TaskExecution taskExecution) {
        taskExecution.setExitMessage("success");
    }
}