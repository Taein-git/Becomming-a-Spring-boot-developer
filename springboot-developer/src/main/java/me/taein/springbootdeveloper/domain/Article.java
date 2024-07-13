package me.taein.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)  // 엔티티의 생성 및 수정 시간을 자동으로 감시하고 기록하기 위한 리스너 애너테이션
@Entity
@Getter // 게터 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 생성
public class Article {

    @CreatedDate    // 엔티티가 생성될 때 생성시간 저장   
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @LastModifiedDate   // 엔티티가 수정될 떄 수정 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // NOT NULL
    private String title;

    @Column(name = "content", nullable = false) // NOT NULL
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
