package com.example.firstproject.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @DisplayName("특정 게시글의 모든 댓글 조회")
    @Test
    void findByArticleId() {
        /* Case 1 : 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력
            // 2. 실제
            // 3. 예상
            // 4. 비교
        }
    }

    @DisplayName("")
    @Test
    void findByNickname() {
    }
}