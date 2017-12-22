package com.schooldrive.logic.hoursinterval;

import com.schooldrive.persistence.hoursinterval.HoursInterval;

/**
 * Created by Filip on 16.12.2017.
 */
public class HoursIntervalPresentation {

    private Integer id;
    private String startTime;
    private String endTime;

    public HoursIntervalPresentation() {
    }

    public HoursIntervalPresentation(HoursInterval hoursInterval) {
        this.id = hoursInterval.getId();
        this.startTime = hoursInterval.getStartTime();
        this.endTime = hoursInterval.getEndTime();
    }

    public Integer getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
