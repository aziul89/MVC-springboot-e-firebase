package com.example.ConCon.controllers;

import com.example.ConCon.model.Commentary;
import com.example.ConCon.service.CommentaryService; 
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class CommentaryController { 

    private final CommentaryService commentaryService; 

    @Autowired
    public CommentaryController(CommentaryService commentaryService) { 
        this.commentaryService = commentaryService;
    }

    @GetMapping("/commentaries") 
    public List<Commentary> getAllCommentaries() throws ExecutionException, InterruptedException { 
        return commentaryService.getCommentaries(); 
    }

    @PostMapping("/commentaries") 
    public String addCommentary(@Valid @RequestBody Commentary commentary, BindingResult bindingResult) throws ExecutionException, InterruptedException { 
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
            return "Error";
        } else {
            System.out.println();
            System.out.println(commentary);
            return commentaryService.createCommentary(commentary); 
        }
    }

    @DeleteMapping("/commentaries/{id}") 
    public String removeCommentary(@PathVariable String id) throws ExecutionException, InterruptedException {
        return commentaryService.deleteCommentary(id); 
    }

    @PutMapping("/commentaries/{id}") 
    public String updateCommentary(@PathVariable String id, @RequestBody Commentary commentary) throws ExecutionException, InterruptedException {
        return commentaryService.updateCommentary(commentary); 
    }
}
