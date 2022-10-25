package com.Trello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trello.dto.BoardDto;
import com.Trello.exceptios.BoardNotFoundException;
import com.Trello.model.Board;
import com.Trello.model.Card;
import com.Trello.model.CardList;
import com.Trello.model.Tag;
import com.Trello.repository.BoardRepository;
import com.Trello.service.BoardService;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("trello")
public class BoardController {

    @Autowired
    BoardRepository boardRepository;
    
    @Autowired
    private BoardService boardService;

    @PostMapping(value = "/board", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertBoardDetails(@RequestBody Board board){
        boardService.insert(board);
        return new ResponseEntity<String>("Data inserted successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/boards/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardDto> findBoardById(@PathParam("id") String id) throws BoardNotFoundException{
        int bId = Integer.parseInt(id);
        BoardDto board = null;
		try {
			board = boardService.getBoardById(bId);
		} catch (Exception e) {
			throw new BoardNotFoundException("Board not found!");
		}
        ResponseEntity<BoardDto> responseEntity = new ResponseEntity<>(board, HttpStatus.OK);
        return responseEntity;
    }
    
    @GetMapping(value = "/boards/Tag/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<Integer, Tag>> getTagMapByBoardId(@PathParam("id") String id) throws BoardNotFoundException{
    	int bId = Integer.parseInt(id);
        HashMap<Integer, Tag> boardList = null;
		try {
			boardList = boardService.getTagMapByBoardId(bId);
		} catch (Exception e) {
			throw new BoardNotFoundException("Board not found!");
		}
        ResponseEntity<HashMap<Integer, Tag>> responseEntity = new ResponseEntity<>(boardList, HttpStatus.OK);
        return responseEntity;
    }
    
    @GetMapping(value = "/boards/cards/{boardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkedHashMap<Integer, CardList>> getCardListMapByBoardId(@PathParam("boardId") String boardId) throws BoardNotFoundException{
    	int bId = Integer.parseInt(boardId);
    	LinkedHashMap<Integer, CardList> cardList = null;
		try {
			cardList = boardService.getCardListMapByBoardId(bId);
		} catch (Exception e) {
			throw new BoardNotFoundException("Board not found!");
		}
        ResponseEntity<LinkedHashMap<Integer, CardList>> responseEntity = new ResponseEntity<>(cardList, HttpStatus.OK);
        return responseEntity;
    }
    
    @GetMapping(value = "/boards/cards/card/{boardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<Integer, Card>> getCardMapByBoardId(@PathParam("boardId") String boardId) throws BoardNotFoundException{
    	int bId = Integer.parseInt(boardId);
    	HashMap<Integer, Card> cardList = null;
		try {
			cardList = boardService.getCardMapByBoardId(bId);
		} catch (Exception e) {
			throw new BoardNotFoundException("Board not found!");
		}
        ResponseEntity<HashMap<Integer, Card>> responseEntity = new ResponseEntity<>(cardList, HttpStatus.OK);
        return responseEntity;
    }
}
