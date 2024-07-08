package me.taein.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.taein.springbootdeveloper.domain.Article;
import me.taein.springbootdeveloper.dto.AddArticleRequest;
import me.taein.springbootdeveloper.dto.UpdateArticleRequest;
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

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        // id 값으로 엔티티를 조회하는데 없으면 예외 발생
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
