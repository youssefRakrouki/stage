package com.stage.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActionResource {

    @Autowired
    private ActionService actionService;

    @GetMapping("/actions")
    public List<Action> getAllAction()
    {
        return actionService.findAll();
    }
    @DeleteMapping("/actions/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable String id){
        Action action = actionService.deleteById(id);

        if(action!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();



    }
}
