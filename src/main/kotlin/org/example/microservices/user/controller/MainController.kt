package org.example.microservices.user.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class MainController {
    @GetMapping("/get/{id}")
    fun getUserById(@PathVariable("id") userId: Int): String {

        return ""
    }

    @PostMapping("/add")
    fun addUser(username: String, password: String, passwordVerification: String, email: String): String {

        return ""
    }

    @PostMapping("/activate")
    fun activateUser(activationCode: String): String {

        return ""
    }

    @GetMapping("/users/list")
    fun listUsers() {

    }
}