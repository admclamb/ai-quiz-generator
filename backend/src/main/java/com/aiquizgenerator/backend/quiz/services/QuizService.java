package com.aiquizgenerator.backend.quiz.services;

import com.aiquizgenerator.backend.common.pagination.dtos.PaginationDTO;
import com.aiquizgenerator.backend.common.pagination.mapper.PaginationMapper;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public Map<String, Object> findAllPaginated(PaginationDTO paginationDTO) {
        Pageable paging = PageRequest.of(paginationDTO.getPage() - 1, paginationDTO.getSize());
        Page<Quiz> quizzes = quizRepository.findAllBeforeTimestamp(paging, paginationDTO.getTimestamp());
        return PaginationMapper.map(quizzes);
    }

    @Transactional
    public Quiz findOneById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }
}
