package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.data.entity.Publisher;
import ru.otus.data.repository.PublisherRepository;
import ru.otus.service.PublisherService;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    PublisherRepository repository;

    @Override
    public void addNewPublisher(String name) {
        if (repository.findFirstByName(name) == null) {
            repository.save(new Publisher(name));
        } else {
            throw new RuntimeException("This publisher already exists");
        }
    }
}
