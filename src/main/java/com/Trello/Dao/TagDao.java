package com.Trello.Dao;

import java.util.List;

import com.Trello.model.Tag;

public interface TagDao {
    /**
     * @return A list of all tags
     * @throws Exception DataSource exception
     */
    List<Tag> getAllByBoardId(int boardId) throws Exception;
}
