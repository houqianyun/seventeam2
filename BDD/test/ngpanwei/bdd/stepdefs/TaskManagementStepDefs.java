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
	@Given("^�Ŷ������� \"(.*?)\" ���ȼ�\"(.*?)\"$")
	public void �Ŷ�������_���ȼ�(String taskName, String priority) throws Throwable {
		Task newTask = backlog.add(taskName) ;
        assertNotNull(newTask) ;
	}    
	@Given("^�Ŷ������� \"(.*?)\" ���ȼ� \"(.*?)\"$")
	public void �Ŷ�������_���ȼ�2(String taskName, String priority) throws Throwable {
		Task newTask = backlog.add(taskName) ;
		newTask.setPriority(priority);
        assertNotNull(newTask) ;
	}
	@When("^�Ŷ����\"(.*?)\"$")
	public void �Ŷ����(String taskName) throws Throwable {
		System.err.println(taskName);
		Task task = backlog.setTaskStatus(taskName,Task.STATUS_DONE) ;
        assertNotNull("task should exist in backlog",task) ;
	}
	@Then("^�Ŷӵ�δ���������\"(.*?)\"$")
	public void �Ŷӵ�δ���������(String taskName) throws Throwable {
        List<Task> tasks = backlog.getUnompleteTask() ;
        Task task = tasks.get(0) ;
        assertEquals(task.getName(),taskName) ;
	}
	@Then("^�Ŷӵ�δ���\"(.*?)\"���ȼ� ������\"(.*?)\"$")
	public void �Ŷӵ�δ���_���ȼ�_������(String priority, String taskName) throws Throwable {
        List<Task> tasks = backlog.getUnompleteTask() ;
        Task task = tasks.get(0) ;
        assertEquals(task.getName(),taskName) ;
	}
}
