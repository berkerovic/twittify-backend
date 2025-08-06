package com.berkerser.twittify.repository;

import com.berkerser.twittify.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>{
    //Belirli bir kullanıcının tüm postlarını getir.
    List<Post> findByUserId(Long userId);
}
