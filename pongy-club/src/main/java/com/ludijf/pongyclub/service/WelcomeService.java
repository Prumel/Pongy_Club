package com.ludijf.pongyclub.service;

import com.ludijf.pongyclub.entity.Training;
import java.util.List;

public interface WelcomeService {

    /**
     * Retrieves all active trainings.
     *
     * @return a list of all active trainings.
     */
    List<Training> findTrainings();
}
