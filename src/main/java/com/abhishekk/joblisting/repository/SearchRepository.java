package com.abhishekk.joblisting.repository;

import com.abhishekk.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
