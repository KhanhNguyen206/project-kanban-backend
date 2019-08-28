package com.khanhnn.kanbanwebservice.service.impl;

import com.khanhnn.kanbanwebservice.model.Backlog;
import com.khanhnn.kanbanwebservice.repository.BacklogRepository;
import com.khanhnn.kanbanwebservice.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BacklogServiceImpl implements BacklogService {

    @Autowired
    private BacklogRepository backlogRepository;


    @Override
    public List<Backlog> findAll() {
        return this.backlogRepository.findAll();
    }

    @Override
    public Backlog findById(Long id) {
        return this.backlogRepository.findById(id).get();
    }

    @Override
    public void save(Backlog backlog) {
        this.backlogRepository.save(backlog);
    }

    @Override
    public void delete(Long id) {
        this.backlogRepository.deleteById(id);
    }
}
