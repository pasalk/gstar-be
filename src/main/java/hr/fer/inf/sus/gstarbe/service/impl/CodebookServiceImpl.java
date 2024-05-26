package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.CodebookMapper;
import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;
import hr.fer.inf.sus.gstarbe.repository.*;
import hr.fer.inf.sus.gstarbe.service.CodebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodebookServiceImpl implements CodebookService {

    final ResultTypeRepository resultTypeRepository;
    final StatisticsTypeRepository statisticsTypeRepository;
    final TournamentFormatRepository tournamentFormatRepository;
    final TournamentStatusRepository tournamentStatusRepository;
    final UserTypeRepository userTypeRepository;
    final CodebookMapper codebookMapper;
    final TournamentStructureRepository tournamentStructureRepository;

    @Override
    public List<KeyValueDto> getAllResultTypes() {
        return resultTypeRepository.findAll().stream().map(codebookMapper::resultTypeToDto).toList();
    }

    @Override
    public List<KeyValueDto> getAllStatisticsTypes() {
        return statisticsTypeRepository.findAll().stream().map(codebookMapper::statisticsTypeToDto).toList();
    }

    @Override
    public List<KeyValueDto> getAllTournamentFormats() {
        return tournamentFormatRepository.findAll().stream().map(codebookMapper::tournamentFormatToDto).toList();
    }

    @Override
    public List<KeyValueDto> getAllTournamentStatuses() {
        return tournamentStatusRepository.findAll().stream().map(codebookMapper::tournamentStatusToDto).toList();
    }

    @Override
    public List<KeyValueDto> getAllUserTypes() {
        return userTypeRepository.findAll().stream().map(codebookMapper::userTypeToDto).toList();
    }

    @Override
    public List<KeyValueDto> getAllTournamentStructures() {
        return tournamentStructureRepository.findAll().stream().map(codebookMapper::tournamentStructureToDto).toList();
    }
}
