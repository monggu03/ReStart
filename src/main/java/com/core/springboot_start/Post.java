package com.core.springboot_start;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // 아래의 필드를 가진 생성자가 생김
@Entity
@Table(name="posts") //테이블 이름 정하기

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;//id를 long으로

    private String content;

    private LocalDateTime createdAt;

    public void updateContent(String content){
        this.content = content;
    }
}
