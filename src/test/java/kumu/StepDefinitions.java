package kumu;

import io.cucumber.java.en.*;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions.*;

class Task {
    private String description;
    private int priorityLevel;
    private Boolean isFinished;
    
    public Task(String description, int priorityLevel) {
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.isFinished = false;
    }

    public void setTaskPriority(int level) {
        this.priorityLevel = level;
    }

    public void finishTask() {
        this.isFinished = true;
    }
}

public class StepDefinitions {
    // 1 - register
    // 2 - log in
    Number startOption;

    // 1 - user register
    // 2 - task register
    // 3 - task list
    Number loggedOption;

    Boolean isUserLoggedIn = false;
    Task newTask = new Task("Tarefa 1", 0);

    private void fakeStartApp() {
        System.err.println("Bem vindo ao KUMU!");
    }

    private void showUserRegisterForm() {
        System.err.println("Formulário de cadastro de usuário:");
    }

    private void showTaskForm() {
        System.err.println("Formulário de cadastro de tarefa:");
    }

    private void showTaskList() {
        System.err.println("Lista de tarefas: ");
    }

    private void userRegisterForm() {
        System.err.println("Qual seu nome?");
        System.err.println("Qual seu e-mail?");
        System.err.println("Qual sua senha?");
    }

    private void taskForm() {
        System.err.println("Qual o nome da tarefa?");
        System.err.println("Qual a prioridade? (0 - Comum, 1 - Prioritária)");
    }

    // User register feature
    @Given("the user is not registered in kumu")
    public void the_user_is_not_registered_in_kumu() {
        fakeStartApp();
    }
    @When("he chooses the option to sign in")
    public void he_chooses_the_option_to_sign_in() {
        this.startOption = 1;
    }
    @Then("he sees the form")
    public void he_sees_the_form() {
        showUserRegisterForm();
    }    

    @Given("the user is in the registration form")
    public void the_user_is_in_the_registration_form() {
        showUserRegisterForm();
    }
    @When("he fills all the information")
    public void he_fills_all_the_information() {
        userRegisterForm();
    }
    @Then("he authenticates himself in the app")
    public void he_authenticates_himself_in_the_app() {
        this.isUserLoggedIn = true;
    }


    // Adding task feature
    @Given("the user is logged in to add a task")
    public void the_user_is_logged_in_to_add_a_task() {
        this.isUserLoggedIn = true;
    }
    @When("he chooses the option to add a new task")
    public void he_chooses_the_option_to_add_a_new_task() {
        this.loggedOption = 2;
    }
    @Then("he sees the task form")
    public void he_sees_the_task_form() {
        showTaskForm();
    }

    @Given("the user is in task form")
    public void the_user_is_in_task_form() {
        showTaskForm();
    }
    @When("he submits the task info")
    public void he_submits_the_task_info() {
        taskForm();
    }
    @Then("he sees the list of pending tasks")
    public void he_sees_the_list_of_pending_tasks() {
        this.loggedOption = 3;
        showTaskList();
    }


    // Updating task feature
    @Given("the user is logged in to set a task priority")
    public void the_user_is_logged_in_to_set_a_task_priority() {
        this.isUserLoggedIn = true;
    }
    @Given("he selected the task")
    public void he_selected_the_task() {
        // todo in real app
    }
    @When("he fills the priority level field to {int}")
    public void he_fills_the_priority_level_field_to(Integer int1) {
        newTask.setTaskPriority(int1);
    }
    @Then("he sees a message of prioritizing concluded")
    public void he_sees_a_message_of_prioritizing_concluded() {
        System.err.println("Task priorizada com sucesso!");
    }

    @Given("the user is logged in to finish a task")
    public void the_user_is_logged_in_to_finish_a_task() {
        this.isUserLoggedIn = true;
    }
    @Given("he selected a task")
    public void he_selected_a_task() {
        // todo in real app
    }
    @When("he sets the completed field to {int}")
    public void he_sets_the_completed_field_to(Integer int1) {
        newTask.finishTask();
    }
    @Then("he sees a message of task finished")
    public void he_seed_a_message_of_task_finished() {
        System.err.println("Task finalizada com sucesso!");
    }

}
