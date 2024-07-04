package com.umc.dream.domain;

import com.umc.dream.domain.common.BaseEntity;
import com.umc.dream.domain.enums.DreamCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dream extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate date;

    private LocalDateTime sleepTime;

    private LocalDateTime wakeUpTime;

    @Column(nullable = false, length = 100)
    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private DreamCategory category;

    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<People> characters = new ArrayList<>();

    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Place> places = new ArrayList<>();

    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feeling> feelings = new ArrayList<>();

    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hashtag> hashtags = new ArrayList<>();

    @OneToMany(mappedBy = "dream", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public Dream(User user, LocalDate date, LocalDateTime sleepTime, LocalDateTime wakeUpTime, String title, String content, DreamCategory category) {
        this.user = user;
        this.date = date;
        this.sleepTime = sleepTime;
        this.wakeUpTime = wakeUpTime;
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
