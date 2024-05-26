package hr.fer.inf.sus.gstarbe.service;

import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;

import java.util.List;

public interface CodebookService {
    List<KeyValueDto> getAllResultTypes();

    List<KeyValueDto> getAllStatisticsTypes();

    List<KeyValueDto> getAllTournamentFormats();

    List<KeyValueDto> getAllTournamentStatuses();

    List<KeyValueDto> getAllUserTypes();

    List<KeyValueDto> getAllTournamentStructures();
}
