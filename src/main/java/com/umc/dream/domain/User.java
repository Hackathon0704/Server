package com.umc.dream.domain;

import com.umc.dream.domain.common.BaseEntity;
import com.umc.dream.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String account;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Dream> dreamList = new ArrayList<>();

    @Builder
    public User(String name, String account, String password, Role role) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.role = role;
    }
}
