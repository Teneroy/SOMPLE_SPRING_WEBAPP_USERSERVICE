package org.example.microservices.user.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {
    private val userRepo: String = ""

    private val mailSender: String = "" // Delete

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Value("\${hostname}")
    lateinit var hostname: String

    fun loadUserByUsername(username: String): UserDetails? { // Change type to UserDetails
        return null
    }

    fun addUser(/*user: User*/): Boolean {
        return true
    }

    fun sendEmail(/*user: User*/): Boolean {
        return true
    }

    fun activateUser(code: String): Boolean {
        return true
    }

    fun findAll(): List<String>? {// Change type to List<User>
        return null
    }

    fun saveUser(/*user: User,*/ password: String, email: String): Boolean {
        return true
    }

    fun unsubscribe(/*currentUser: User, user: User*/): Boolean {
        return true
    }

    fun subscribe(/*currentUser: User, user: User*/): Boolean {
        return true
    }
}