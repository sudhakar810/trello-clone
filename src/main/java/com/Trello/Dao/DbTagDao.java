package com.Trello.Dao;


import javax.sql.DataSource;

import com.Trello.model.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbTagDao implements TagDao {
    private DataSource dataSource;

    public DbTagDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Tag> getAllByBoardId(int boardId) throws RuntimeException {
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT `id`, `name`, `colorId`, `hidden` "
                    + "FROM `tags` "
                    + "WHERE `boardId` = ?"
            );
            stmt.setInt(1, boardId);
            ResultSet r = stmt.executeQuery();

            List<Tag> tags = new ArrayList<>();

            while (r.next()) {
                tags.add(createTag(r));
            }

            return tags;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    private Tag createTag(ResultSet r) throws SQLException {
        Tag tag = new Tag();
        tag.setId(r.getInt("id"));
        tag.setName(r.getString("name"));
        tag.setColorId(r.getInt("colorId"));
        tag.setHidden(r.getBoolean("hidden"));
        return tag;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
