package ru.test.mimimimetr.demo.servise;

import ru.test.mimimimetr.demo.pojo.Cat;

public interface VoteService {
    String nextImg();

    Long vote(Cat cat);

    void save(Cat cat);

    void delete(Long id);
}
