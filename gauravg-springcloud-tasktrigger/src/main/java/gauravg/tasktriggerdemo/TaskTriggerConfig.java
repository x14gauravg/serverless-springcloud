package gauravg.tasktriggerdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskTriggerConfig {

	@Bean
	public TaskProcessor taskProcessor() {
		return new TaskProcessor();
	}
}
