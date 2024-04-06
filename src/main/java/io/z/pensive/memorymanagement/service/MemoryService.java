package io.z.pensive.memorymanagement.service;
import java.util.List;

import io.z.pensive.memorymanagement.model.*;

public interface MemoryService {
    Memory saveMemory(Memory memory);
    Memory updateMemory(Long id, Memory memory);
    void deleteMemory(Long id);
    Memory getMemoryById(Long id);
    List<Memory> getAllMemories();
}

