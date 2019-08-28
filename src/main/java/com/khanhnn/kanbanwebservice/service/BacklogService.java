package com.khanhnn.kanbanwebservice.service;

import com.khanhnn.kanbanwebservice.model.Backlog;

import java.util.List;

public interface BacklogService {

    List<Backlog> findAll();

    Backlog findById(Long id);

    void save(Backlog backlog);

    void delete(Long id);
}
