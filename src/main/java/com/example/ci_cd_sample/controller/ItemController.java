package com.example.ci_cd_sample.controller;

import com.example.ci_cd_sample.model.Item;
import com.example.ci_cd_sample.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    @Operation(summary = "대시보드 - 총DB수 조회" , description = "대시보드 - 총DB수 조회",
            parameters = {
                    @Parameter(name = "startDate", description = "시작일", example = "2023-05-01"),
                    @Parameter(name = "endDate", description = "종료일", example = "2023-05-31")
            })
    @GetMapping(value = "/get-total-db-count")
    public List<Item>  getAllItems() {
        return itemService.findAll();
    }
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> item = itemService.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.save(item);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.findById(id)
                .map(existingItem -> {
                    item.setId(id);
                    Item updatedItem = itemService.save(item);
                    return ResponseEntity.ok(updatedItem);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        return itemService.findById(id)
                .map(item -> {
                    itemService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
