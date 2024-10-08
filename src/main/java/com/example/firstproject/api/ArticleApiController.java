package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    //    @Autowired
//    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        //return articleRepository.findAll();
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        //return articleRepository.findById(id).orElse(null);
        return articleService.show(id);
    }

    // POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        //Article article = dto.toEntity();
        //return articleRepository.save(article);
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        // 1. 수정용 엔티티 생성하기
        //Article article = dto.toEntity();
        //log.info("id:{}, article:{}", id, article.toString());

        // 2. DB에 대상 엔티티가 있는지 조회하기
        //Article target = articleRepository.findById(article.getId()).orElse(null);

        // 3. 대상 엔티티가 없거나 수정하려는 id가 잘 못 됐을 경우 처리하기
        //if (target == null || id != article.getId()) {
        //    // 400, 잘못된 요청 응답
        //    log.info("잘못된 요청, id:{}, article:{}", id, article.getId());
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        //}
        //target.patch(article);
        //Article updated = articleRepository.save(target);
        //return ResponseEntity.status(HttpStatus.OK).body(updated);

        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }


    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        // 1. 대상 찾기
        //Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        //if (target == null) {
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        //}
        // 3. 대상 삭제
        //articleRepository.delete(target);
        //return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
