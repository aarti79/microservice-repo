package spring.cloud.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRunRepository extends JpaRepository<TaskRunOutput, Long>{
	
}
