package io.z.pensive.memorymanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import io.z.pensive.memorymanagement.model.*;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
    // Additional custom query methods can be added here if needed
}
