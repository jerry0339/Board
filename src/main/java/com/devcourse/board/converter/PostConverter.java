package com.devcourse.board.converter;

import com.devcourse.board.domain.post.Post;
import com.devcourse.board.domain.post.vo.Content;
import com.devcourse.board.domain.post.vo.Title;
import com.devcourse.board.domain.user.User;
import com.devcourse.board.dto.post.PostCreateRequest;
import com.devcourse.board.dto.post.PostResponse;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    // Todo : 모든 Dto와 Vo 그리고 Converter클래스에서 어색하거나 효율적이지 못한 부분?
    public Post convertToPost(PostCreateRequest dto, User user) {
        return Post.builder()
            .title(new Title(dto.getTitle()))
            .content(new Content(dto.getContent()))
            .user(user)
            .build();
    }

    public PostResponse convertToPostResponse(Post post) { // Todo : Api마다 다른 Response dto를 만들어 줘야 함?
        return PostResponse.builder()
            .id(post.getId())
            .title(post.getTitle().getTitle())
            .content(post.getContent().getContent())
            .build();
    }

}