package me.taein.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.taein.springbootdeveloper.domain.Article;
import me.taein.springbootdeveloper.dto.AddArticleRequest;
import me.taein.springbootdeveloper.dto.ArticleResponse;
import me.taein.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형식으로 변환하는 컨트롤러
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll() // List<Article>를 List<ArticleResponse> 로 파싱
                .stream()       // 여러 데이터가 모여 있는 컬렉션을 간편하게 처리
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }
}
