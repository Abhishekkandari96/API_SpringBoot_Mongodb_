package com.abhishekk.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.abhishekk.joblisting.model.Post;
public interface PostRepository extends MongoRepository<Post, String> {

}
