package com.ua.education.examinator.historyService.repo;

import com.ua.education.examinator.historyService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<Question, Integer> {
}
