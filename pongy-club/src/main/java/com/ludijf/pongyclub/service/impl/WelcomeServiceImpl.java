package com.ludijf.pongyclub.service.impl;

import com.ludijf.pongyclub.entity.Training;
import com.ludijf.pongyclub.repository.TrainingDao;
import com.ludijf.pongyclub.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    private TrainingDao trainingDao;

    @Autowired
    public WelcomeServiceImpl(TrainingDao trainingDao) {
        this.trainingDao = trainingDao;
    }

  @Override
  public List<Training> findTrainings() {
    List<Training> allTrainings = trainingDao.findAll();
    List<Training> activeTrainings = new ArrayList<>();

    for (Training training : allTrainings) {
        if (training.getDeactivationDate() == null || training.getDeactivationDate().isAfter(LocalDate.now())) {
            activeTrainings.add(training);
        }
    }

    return activeTrainings;
  }

}
