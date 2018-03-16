package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.*

//http://localhost:4567/tasks
fun main(args: Array<String>) {
    val objectMapper = ObjectMapper().registerKotlinModule();
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    path("/tasks") {
        get("", taskController.index(), jsonTransformer)
        post("", taskController.create(), jsonTransformer)
        get("/:id", taskController.show(), jsonTransformer)
        delete("/:id", taskController.destroy(), jsonTransformer)
        patch("/:id", taskController.update(), jsonTransformer)

    }

}