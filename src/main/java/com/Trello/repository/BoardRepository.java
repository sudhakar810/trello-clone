package com.Trello.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.Trello.model.Board;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board, Integer> {

    @Override
    <S extends Board> S insert(S entity);

    @Override
    List<Board> findAll(Sort sort);
}
