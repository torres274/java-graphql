package com.example.java.graphql.resolver;

import com.example.java.graphql.exception.PostNotFoundException;
import com.example.java.graphql.model.Post;
import com.example.java.graphql.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final PostRepository postRepository;

    public Post post(String id) {
        return postRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new PostNotFoundException("Post not found", id));
    }

    public Iterable<Post> allPosts() {
        return postRepository.findAll();
    }

}
