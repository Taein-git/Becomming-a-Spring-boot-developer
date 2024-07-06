package me.taein.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.taein.springbootdeveloper.domain.Article;
import me.taein.springbootdeveloper.dto.AddArticleRequest;
import me.taein.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈으로 등록
@RequiredArgsConstructor    // final 이 붙거나 @NotNull이 붙은 필드의 생성자 추가 (의존 주입)
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
