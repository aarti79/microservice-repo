package spring.cloud.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_RUN_OUTPUT")
public class TaskRunOutput {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String output;

	public TaskRunOutput() {
	}

	public TaskRunOutput(String output) {
		this.output = output;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return "TaskRunOutput{" + "id=" + this.id + ", output='" + this.output + '\'' + '}';
	}
}
