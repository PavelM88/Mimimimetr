package ru.test.mimimimetr.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.mimimimetr.demo.pojo.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
