package org.example.microservices.user.repos

import org.example.microservices.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User, Long> {
    fun findByUsername(username: String): User

    fun findByActivationCode(code: String): User
}