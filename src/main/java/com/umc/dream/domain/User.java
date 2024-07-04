package com.umc.dream.domain;

import com.umc.dream.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String account;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String account, String password, Role role) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.role = role;
    }
}
