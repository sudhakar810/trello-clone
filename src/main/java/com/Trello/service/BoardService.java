package com.Trello.service;



import java.util.*;

import com.Trello.Dao.BoardDao;
import com.Trello.Dao.CardDao;
import com.Trello.Dao.CardListDao;
import com.Trello.Dao.ColorDao;
import com.Trello.Dao.TagDao;
import com.Trello.dto.BoardDto;
import com.Trello.dto.CardRequestDto;
import com.Trello.model.Board;
import com.Trello.model.Card;
import com.Trello.model.CardList;
import com.Trello.model.Color;
import com.Trello.model.Tag;

public class BoardService {
    private final BoardDao boardDao;
    private final CardDao cardDao;
    private final CardListDao listDao;
    private final ColorDao colorDao;
    private final TagDao tagDao;

    public BoardService(
        BoardDao boardDao,
        CardDao cardDao,
        CardListDao listDao,
        ColorDao colorDao,
        TagDao tagDao
    ) {
        this.boardDao = boardDao;
        this.cardDao = cardDao;
        this.colorDao = colorDao;
        this.listDao = listDao;
        this.tagDao = tagDao;
    }

    public BoardDto getBoardById(int id) throws Exception {
        Board board = boardDao.getById(id)
            .orElseThrow(() -> new RuntimeException("Could not find board with ID " + id));

        int boardId = board.getId();

        HashMap<Integer, Card> cardMap = getCardMapByBoardId(boardId);
        LinkedHashMap<Integer, CardList> listMap = getCardListMapByBoardId(boardId);
        List<Integer> listIds = new ArrayList<>(listMap.keySet());
        HashMap<Integer, Color> colorMap = getColorMap();
        HashMap<Integer, Tag> tagMap = getTagMapByBoardId(boardId);

        BoardDto data = new BoardDto();
        data.setId(board.getId());
        data.setName(board.getName());
        data.setListIds(listIds);
        data.setCards(cardMap);
        data.setColors(colorMap);
        data.setLists(listMap);
        data.setTags(tagMap);
        return data;
    }

    public HashMap<Integer, Card> getCardMapByBoardId(int boardId) throws Exception {
        CardRequestDto params = new CardRequestDto();
        params.setBoardId(boardId);
        List<Card> cards = cardDao.getAll(params);
        HashMap<Integer, Card> cardMap = new HashMap<>();
        for (Card card : cards) cardMap.put(card.getId(), card);
        return cardMap;
    }

    public LinkedHashMap<Integer, CardList> getCardListMapByBoardId(int boardId) throws Exception {
        List<CardList> lists = listDao.getAllByBoardId(boardId);
        LinkedHashMap<Integer, CardList> listMap = new LinkedHashMap<>();
        for (CardList list : lists) listMap.put(list.getId(), list);
        return listMap;
    }

    public HashMap<Integer, Color> getColorMap() throws Exception {
        List<Color> colors = colorDao.getAll();
        HashMap<Integer, Color> colorMap = new HashMap<>();
        for (Color color : colors) colorMap.put(color.getId(), color);
        return colorMap;
    }

    public HashMap<Integer, Tag> getTagMapByBoardId(int boardId) throws Exception {
        List<Tag> tags = tagDao.getAllByBoardId(boardId);
        HashMap<Integer,  Tag> tagMap = new HashMap<>();
        for (Tag tag : tags) tagMap.put(tag.getId(), tag);
        return tagMap;
    }
    
    public <S extends Board> S insert(S entity) {
		
		return boardDao.insert(entity);
	} 
}
