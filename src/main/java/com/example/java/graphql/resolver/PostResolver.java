package com.example.java.graphql.resolver;

import com.example.java.graphql.model.Post;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostResolver implements GraphQLResolver<Post> {

    // private ExampleRepository exampleRepository;

    // public PostResolver(ExampleRepository exampleRepository) {
        // this.exampleRepository = exampleRepository;
    // }

    // public Example example(Post post) {
        // return exampleRepository.findById(post.getId());
    // }

}
