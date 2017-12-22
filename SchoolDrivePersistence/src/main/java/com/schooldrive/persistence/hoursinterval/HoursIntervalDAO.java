package com.schooldrive.persistence.hoursinterval;

import java.util.List;

/**
 * Created by Filip on 16.12.2017.
 */
public interface HoursIntervalDAO {

    HoursInterval getHoursIntervalById(Integer id);
    List<HoursInterval> getAllHourIntervals();
}
