package me.taein.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.taein.springbootdeveloper.domain.Article;

@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@NoArgsConstructor  // 기본 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { // 빌더패턴을 이용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }

}
