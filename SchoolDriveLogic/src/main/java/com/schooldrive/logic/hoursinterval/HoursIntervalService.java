package com.schooldrive.logic.hoursinterval;

import com.schooldrive.persistence.hoursinterval.HoursInterval;
import com.schooldrive.persistence.hoursinterval.HoursIntervalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Filip on 16.12.2017.
 */
@Service
public class HoursIntervalService {

    HoursIntervalDAO hoursIntervalDAO;

    @Autowired
    public HoursIntervalService(HoursIntervalDAO hoursIntervalDAO) {
        this.hoursIntervalDAO = hoursIntervalDAO;
    }

    public List<HoursInterval> getAllHourIntervals() {
        return this.hoursIntervalDAO.getAllHourIntervals();
    }
}
