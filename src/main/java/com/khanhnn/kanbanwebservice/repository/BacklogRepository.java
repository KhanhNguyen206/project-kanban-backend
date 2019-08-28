package com.khanhnn.kanbanwebservice.repository;

import com.khanhnn.kanbanwebservice.model.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT })
public interface BacklogRepository extends JpaRepository<Backlog, Long> {
}
