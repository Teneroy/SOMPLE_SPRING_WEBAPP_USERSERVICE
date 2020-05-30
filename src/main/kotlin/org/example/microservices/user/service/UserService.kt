package org.example.microservices.user.service

import org.example.microservices.user.domain.Role
import org.example.microservices.user.domain.User
import org.example.microservices.user.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
    @Autowired
    private lateinit var userRepo: UserRepo

    private val mailSender: String = "" // Delete(will be changed to microservice)

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Value("\${hostname}")
    lateinit var hostname: String

    fun loadUserByUsername(username: String): User { // Change type to UserDetails
        return userRepo.findByUsername(username) ?: throw UsernameNotFoundException("Incorrect login data")
    }

    fun addUser(user: User): Boolean {
        val userFromDb: User? = userRepo.findByUsername(user.username)

        if (userFromDb != null)
            return false

        user.active = false
        user.roles = Collections.singleton(Role.USER)
        user.activationCode = UUID.randomUUID().toString()
        user.password = passwordEncoder.encode(user.password)

        if (!sendEmail(user)) {
            return false
        }

        userRepo.save(user)

        return true
    }

    fun sendEmail(user: User): Boolean {
        return true
    }

    fun activateUser(code: String): Boolean {
        val user: User = userRepo.findByActivationCode(code) ?: return false

        user.active = true
        user.activationCode = ""
        userRepo.save(user)

        return true
    }

    fun findAll(): List<User> {
        return userRepo.findAll()
    }

    fun saveUser(userId: Long, roles:Set<Role>): Boolean {
        val user: Optional<User> = userRepo.findById(userId) ?: return false

        val userToRepo = User(userId, user.get().username, user.get().email, user.get().password, roles)

        userToRepo.active = true

        userRepo.save(userToRepo)

        return true
    }

    fun updateProfile(user: User, password: String, email: String): Boolean {
        val userEmail: String = user.email

        val emailChanged: Boolean = (email != userEmail)

        if(emailChanged) {
            user.email = email

            if(email.isNotEmpty()) {
                user.activationCode = UUID.randomUUID().toString()
            }
        }

        if(password.isNotEmpty()) {
            user.password = passwordEncoder.encode(password)
        }

        if(emailChanged) {
            if (!sendEmail(user)) {
                return false
            }
        }

        userRepo.save(user)

        return true
    }

    fun unsubscribe(currentUser: User, user: User): Boolean {
        return true
    }

    fun subscribe(currentUser: User, user: User): Boolean {
        return true
    }
}