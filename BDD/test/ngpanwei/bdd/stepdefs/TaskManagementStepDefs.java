package ngpanwei.bdd.stepdefs;
import static org.junit.Assert.*;

import java.util.List;

import ngpanwei.backlog.Backlog;
import ngpanwei.backlog.Task;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class TaskManagementStepDefs {
    Backlog backlog = null ;
    @Before
    public void setup() {
        backlog = new Backlog() ;
    }
	@Given("^团队有任务 \"(.*?)\" 优先级\"(.*?)\"$")
	public void 团队有任务_优先级(String taskName, String priority) throws Throwable {
		Task newTask = backlog.add(taskName) ;
        assertNotNull(newTask) ;
	}    
	@Given("^团队有任务 \"(.*?)\" 优先级 \"(.*?)\"$")
	public void 团队有任务_优先级2(String taskName, String priority) throws Throwable {
		Task newTask = backlog.add(taskName) ;
		newTask.setPriority(priority);
        assertNotNull(newTask) ;
	}
	@When("^团队完成\"(.*?)\"$")
	public void 团队完成(String taskName) throws Throwable {
		System.err.println(taskName);
		Task task = backlog.setTaskStatus(taskName,Task.STATUS_DONE) ;
        assertNotNull("task should exist in backlog",task) ;
	}
	@Then("^团队的未完成任务是\"(.*?)\"$")
	public void 团队的未完成任务是(String taskName) throws Throwable {
        List<Task> tasks = backlog.getUnompleteTask() ;
        Task task = tasks.get(0) ;
        assertEquals(task.getName(),taskName) ;
	}
	@Then("^团队的未完成\"(.*?)\"优先级 任务是\"(.*?)\"$")
	public void 团队的未完成_优先级_任务是(String priority, String taskName) throws Throwable {
        List<Task> tasks = backlog.getUnompleteTask() ;
        Task task = tasks.get(0) ;
        assertEquals(task.getName(),taskName) ;
	}
}
