package com.Trello.Dao;

import java.util.Optional;

import com.Trello.model.Board;

public interface BoardDao {
    Optional<Board> getById(int id) throws Exception;
    
    <S extends Board> S insert(S entity);
}
