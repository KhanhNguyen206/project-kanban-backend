package com.khanhnn.kanbanwebservice.restController;

import com.khanhnn.kanbanwebservice.model.Backlog;
import com.khanhnn.kanbanwebservice.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT })
public class BacklogController {

    @Autowired
    private BacklogService backlogService;

    @GetMapping("/backlogs")
    public ResponseEntity<List<Backlog>> listAllBacklogs() {
        List<Backlog> backlogs = this.backlogService.findAll();

        if (backlogs.isEmpty()) {
            return new ResponseEntity<List<Backlog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Backlog>>(backlogs, HttpStatus.OK);
    }

    @GetMapping("/backlogs/{id}")
    public ResponseEntity<Backlog> getBacklog(@PathVariable Long id) {
        Backlog backlog = this.backlogService.findById(id);

        if (backlog == null) {
            return new ResponseEntity<Backlog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Backlog>(backlog, HttpStatus.OK);
    }

    @PostMapping("/backlogs/")
    public ResponseEntity<Void> createBackLog(@RequestBody Backlog backlog) {
        this.backlogService.save(backlog);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/backlogs/{id}")
    public ResponseEntity<Void> updateBacklog(@RequestBody Backlog backlog, @PathVariable Long id) {
        Backlog currentBacklog = this.backlogService.findById(id);

        if (currentBacklog == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        currentBacklog.setId(backlog.getId());
        currentBacklog.setTitle(backlog.getTitle());
        currentBacklog.setStatus(backlog.getStatus());

        this.backlogService.save(currentBacklog);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/backlogs/{id}")
    public ResponseEntity<Void> deleteBacklog(@PathVariable Long id) {
        Backlog backlog = this.backlogService.findById(id);
        if (backlog == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        this.backlogService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
