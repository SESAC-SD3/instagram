

---
**PostResponse.java DTO 수정 완료**

- `bookmarked` 필드 추가
- `from(Post post)` 메소드에서 `bookmarked`를 `false`로 설정
- `from(Post post, long commentCount, long likeCount, boolean bookmarked)` 메소드 추가

**다음 작업 제안:**

`post/detail.html` 템플릿을 수정하여 북마크 버튼을 추가하고, `PostResponse`의 `bookmarked` 필드에 따라 북마크 상태를 시각적으로 표시하는 작업을 진행할 수 있습니다.
