package com.core.springboot_start.repository;

import com.core.springboot_start.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPostRepository implements PostRepository{

    private final Map<Long, Post> posts = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Post save(Post post) {
        Long id = post.getId() == null ? idGenerator.getAndIncrement() : post.getId();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(posts.get(id));
    }

    @Override
    public void deleteById(Long id) {
        posts.remove(id);
    }

    @Override
    public List<Post> findAllPaged(int page, int size) {
        return posts.values()
                .stream() //데이터를 하나씩 처리함
                .sorted((p1, p2) -> Long.compare(p2.getId(),p1.getId())) //큰순으로 정렬
                .skip((long) page * size) //페이징 - 앞에꺼 뛰어넘기
                .limit(size) // size 만큼만 보여주기
                .toList(); // 그걸 LIST에 담아서 보여주기
    }
}
