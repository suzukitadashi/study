package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Request
import spark.Response
import spark.Route
import spark.Spark.halt

class TaskController(private val objectMapper: ObjectMapper,
                     private val taskRepository: TaskRepository) {

    fun index(): Route = Route { request, response ->
        taskRepository.findAll()
    }

    fun create(): Route = Route { request, response ->

        val request: TaskCreateRequest =
                objectMapper.readValue(request.bodyAsBytes()) ?: throw halt(400)
        val task = taskRepository.create(request.content)
        response.status(201)
        task
    }

    fun show(): Route = Route{request, response ->
        request.task?: throw halt(404)
    }

    fun destroy(): Route = Route{request, response ->
        val task = request.task?: throw halt(404)
        taskRepository.delete(task)
        response.status(204)
    }

    fun update(): Route = Route { request, response ->
        val requestTask: TaskUpdateRequest = objectMapper.readValue(request.bodyAsBytes()) ?: throw halt(400)

        val task = request.task ?: throw halt(404)
        val newTask = task.copy(
                content = requestTask.content ?: task.content,
                done = requestTask.done ?: task.done
        )

        taskRepository.update(newTask)
        response.status(204)
    }

    private val Request.task: Task?
        get() {
            val id = params("id").toLongOrNull()
            return id?.let (taskRepository::findById)
        }


}