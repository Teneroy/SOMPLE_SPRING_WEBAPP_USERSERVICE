package org.example.microservices.user.domain

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    USER, ADMIN;

    override fun getAuthority(): String {
        return name
    }
}