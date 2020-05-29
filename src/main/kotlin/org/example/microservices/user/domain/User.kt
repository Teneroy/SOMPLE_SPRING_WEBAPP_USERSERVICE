package org.example.microservices.user.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users_data")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @NotBlank(message = "Username field can't be empty")
    var username: String ="",

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email field can't be empty")
    var email: String = "",

    @NotBlank(message = "Password field can't be empty")
    var password: String = "",

    @ElementCollection(targetClass = Role::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = [JoinColumn(name = "user_id")])
    @Enumerated(EnumType.STRING)
    var roles: Set<Role>? = null
) {
    var active: Boolean = false
    var activationCode: String = ""


}



