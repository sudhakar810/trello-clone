package com.Trello.Dao;

import java.util.List;

import com.Trello.model.Color;

public interface ColorDao {
    /**
     * @return A list of all colors
     * @throws Exception A DataSource exception
     */
    List<Color> getAll() throws Exception;
}
