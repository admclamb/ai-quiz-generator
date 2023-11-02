package com.aiquizgenerator.backend.quiz.services;

import com.aiquizgenerator.backend.common.pagination.dtos.PaginationDTO;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public Page<Quiz> findAllPaginated(PaginationDTO paginationDTO) {
        Pageable paging = PageRequest.of(paginationDTO.getPage(), paginationDTO.getSize());
        return quizRepository.findAllPageable(paging, paginationDTO.getTimestamp());
    }

    @Transactional
    public Quiz findOneByIdWithoutAnswers(Long id) {
        return quizRepository.findById(id).orElse(null);
    }
}
