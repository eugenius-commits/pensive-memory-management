package io.z.pensive.memorymanagement.service;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import io.z.pensive.memorymanagement.model.*;
import io.z.pensive.memorymanagement.repository.*;
import io.z.pensive.memorymanagement.exception.*;

@Service
public class MemoryServiceImpl implements MemoryService {
    private final MemoryRepository memoryRepository;

    public MemoryServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public Memory saveMemory(Memory memory) {
        return memoryRepository.save(memory);
    }

    @Override
    public Memory updateMemory(Long id, Memory memory) {
        Memory existingMemory = memoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Memory not found with id: " + id));
  
        existingMemory.setTitle(memory.getTitle());
        existingMemory.setDescription(memory.getDescription());

        return memoryRepository.save(existingMemory);
    }

    @Override
    public void deleteMemory(Long id) {
        memoryRepository.deleteById(id);
    }

    @Override
    public Memory getMemoryById(Long id) {
        return memoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Memory not found with id: " + id));
    }

    @Override
    public List<Memory> getAllMemories() {
        return memoryRepository.findAll();
    }
}
