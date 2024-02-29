package com.example.ci_cd_sample.repository;

import com.example.ci_cd_sample.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
