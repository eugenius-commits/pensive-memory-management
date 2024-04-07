package io.z.pensive.memorymanagement.controller;

import io.z.pensive.memorymanagement.model.Memory;
import io.z.pensive.memorymanagement.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping
    public ResponseEntity<List<Memory>> getAllMemories() {
        List<Memory> memories = memoryService.getAllMemories();
        return new ResponseEntity<>(memories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Memory> getMemoryById(@PathVariable("id") Long id) {
        Memory memory = memoryService.getMemoryById(id);
        return new ResponseEntity<>(memory, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Memory> createMemory(@RequestBody Memory memory) {
        Memory createdMemory = memoryService.saveMemory(memory);
        return new ResponseEntity<>(createdMemory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Memory> updateMemory(@PathVariable("id") Long id, @RequestBody Memory memory) {
        Memory updatedMemory = memoryService.updateMemory(id, memory);
        return new ResponseEntity<>(updatedMemory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemory(@PathVariable("id") Long id) {
        memoryService.deleteMemory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
