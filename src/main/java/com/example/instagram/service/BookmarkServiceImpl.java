package com.example.instagram.service;

import com.example.instagram.dto.response.PostResponse;
import com.example.instagram.entity.Bookmark;
import com.example.instagram.entity.Post;
import com.example.instagram.entity.User;
import com.example.instagram.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final PostService postService; // PostService를 사용하여 Post 엔티티를 찾습니다.
    private final UserService userService; // UserService를 사용하여 User 엔티티를 찾습니다.

    @Override
    @Transactional
    public void toggleBookmark(Long postId, Long userId) {
        Optional<Bookmark> existingBookmark = bookmarkRepository.findByPostIdAndUserId(postId, userId);

        // 북마크가 있으면
        if (existingBookmark.isPresent()) {
            bookmarkRepository.delete(existingBookmark.get());
        // 북마크가 없으면
        } else {
            Post post = postService.findById(postId);
            User user = userService.findById(userId);

            Bookmark bookmark = Bookmark.builder()
                    .post(post)
                    .user(user)
                    .build();
            bookmarkRepository.save(bookmark);
        }
    }

    @Override
    public boolean isBookmarked(Long postId, Long userId) {
        return bookmarkRepository.existsByPostIdAndUserId(postId, userId);
    }

    @Override
    public List<PostResponse> getBookmarkedPosts(Long userId) {
        // 특정 사용자가 북마크한 모든 Bookmark 엔티티를 조회
        List<Bookmark> bookmarks = bookmarkRepository.findByUserIdOrderByCreatedAtDesc(userId);

        // Bookmark 엔티티에서 Post를 추출하고 PostResponse로 변환
        return bookmarks.stream()
                .map(Bookmark::getPost) // 북마크 엔티티에서 Post 엔티티를 가져옵니다.
                .map(PostResponse::from) // Post 엔티티를 PostResponse DTO로 변환합니다.
                .collect(Collectors.toList());
    }
}
