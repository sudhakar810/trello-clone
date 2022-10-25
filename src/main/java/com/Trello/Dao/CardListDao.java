package com.Trello.Dao;

import java.util.List;

import com.Trello.model.CardList;

public interface CardListDao {
    List<CardList> getAllByBoardId(int boardId) throws Exception;
}
