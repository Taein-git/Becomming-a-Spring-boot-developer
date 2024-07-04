package me.taein.springbootdeveloper;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드 생성자
@Getter // 게터
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; // DB 테이블의 'id' 컬럼과 매칭

    @Column(name = "name", nullable = false) // NOT NULL
    private String name; // DB 테이블의 'name' 컬럼과 매칭

}
