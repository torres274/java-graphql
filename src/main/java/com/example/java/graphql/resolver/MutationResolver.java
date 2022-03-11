package com.example.java.graphql.resolver;

import com.example.java.graphql.exception.PostNotFoundException;
import com.example.java.graphql.model.Post;
import com.example.java.graphql.dto.PostInput;
import com.example.java.graphql.model.User;
import com.example.java.graphql.repository.PostRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final PostRepository postRepository;

    public Post createPost(PostInput input) {
        Post post = Post.builder()
                .content(input.getContent())
                .likedBy(new ArrayList<User>())
                .comments(new ArrayList<String>())
                .build();
        return postRepository.save(post);
    }

    public Post updatePost(PostInput input) {
        Post post = postRepository.findById(input.getId())
                .orElseThrow(() -> new PostNotFoundException("Post to update was not found",
                        input.getId().toString()));
        post.setContent(input.getContent());
        return postRepository.save(post);
    }

    public boolean deletePost(String id) {
        postRepository.deleteById(new ObjectId(id));
        return true;
    }

    public Post likePost(String postId, User user) {
        Post post = postRepository.findById(new ObjectId(postId))
                .orElseThrow(() -> new PostNotFoundException("Post to like was not found", postId));
        post.getLikedBy().add(user);
        return postRepository.save(post);
    }

    public Post addComment(String postId, String comment) {
        Post post = postRepository.findById(new ObjectId(postId))
                .orElseThrow(() -> new PostNotFoundException("Post to comment was not found", postId));
        post.getComments().add(comment);
        return postRepository.save(post);
    }

}
