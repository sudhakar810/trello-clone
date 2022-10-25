package com.Trello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Trello.model.Board;
import com.Trello.repository.BoardRepository;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @PostMapping(value = "/boardDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertBoardDetails(@RequestBody Board board){
        boardRepository.insert(board);
        return new ResponseEntity<String>("Data inserted successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/boardDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Board>> findAllBoardDetails(){
        List<Board> boardList = boardRepository.findAll();
        ResponseEntity<List<Board>> responseEntity = new ResponseEntity<>(boardList, HttpStatus.OK);

        return responseEntity;
    }
}
