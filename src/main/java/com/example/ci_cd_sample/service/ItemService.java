package com.example.ci_cd_sample.service;

import com.example.ci_cd_sample.model.Item;
import com.example.ci_cd_sample.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    public Item update(Item item) {
        if (item.getId() != null && itemRepository.existsById(item.getId())) {
            return itemRepository.save(item);
        }
        return null; // 혹은 예외 처리
    }
}
