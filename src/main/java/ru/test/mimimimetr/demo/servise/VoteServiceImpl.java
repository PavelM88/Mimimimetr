package ru.test.mimimimetr.demo.servise;

import org.springframework.stereotype.Service;
import ru.test.mimimimetr.demo.pojo.Cat;
import ru.test.mimimimetr.demo.repository.CatRepository;

@Service
public class VoteServiceImpl implements VoteService {

    private final CatRepository catRepository;

    public VoteServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public String nextImg() {
        return null;
    }

    @Override
    public Long vote(Cat cat) {
        return null;
    }

    @Override
    public void save(Cat cat) {
        catRepository.save(cat);
    }

    @Override
    public void delete(Long id) {
        catRepository.deleteById(id);
    }
}
