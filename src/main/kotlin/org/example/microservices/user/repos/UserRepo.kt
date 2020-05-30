package org.example.microservices.user.repos

import org.example.microservices.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepo : JpaRepository<User, Long> {
    override fun findById(id: Long): Optional<User>

    fun findByUsername(username: String): User

    fun findByActivationCode(code: String): User
}