package trademe.domain;

import trademe.domain.enums.Department;
import trademe.domain.valueObjects.DailyRate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public final class Project {

    private final String name;
    private final Contractor responsible;
    private final List<Task> tasks;
    private final Calendar startDate;
    private final Calendar endDate;
    private final Department location;
    private final DailyRate desiredDailyRate;
    private final int durationOfEngagmentInDays;

    private Project(String name, Contractor responsible, List<Task> tasks, Calendar startDate, Calendar endDate,
                    Department location, DailyRate desiredDailyRate, int durationOfEngagmentInDays) {
        this.name = Objects.requireNonNull(name);
        this.responsible = Objects.requireNonNull(responsible);
        this.tasks = Objects.requireNonNull(tasks);
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
        this.location = Objects.requireNonNull(location);
        this.desiredDailyRate = Objects.requireNonNull(desiredDailyRate);
        this.durationOfEngagmentInDays = durationOfEngagmentInDays;
    }

    public static Project of(String name, Contractor responsible, List<Task> tasks, Calendar startDate, Calendar endDate,
                             Department location, DailyRate desiredDailyRate, int durationOfEngagmentInDays) {
        return new Project(name, responsible, tasks, startDate, endDate, location, desiredDailyRate, durationOfEngagmentInDays);
    }

    public String getName() {
        return name;
    }

    public Contractor getResponsible() {
        return responsible;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Department getLocation() {
        return location;
    }

    public DailyRate getDesiredDailyRate() {
        return desiredDailyRate;
    }

    public int getDurationOfEngagmentInDays() {
        return durationOfEngagmentInDays;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name : ").append(name).append("\n");
        result.append("Responsible : \n").append(responsible).append("\n");
        for (Task task : tasks) {
            result.append("------ Task : \n").append(task.toString()).append("\n");
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        result.append("Start date : ").append(format.format(startDate.getTime())).append("\n");
        result.append("End date : ").append(format.format(endDate.getTime())).append("\n");
        result.append("Location : ").append(location).append("\n");
        result.append("Desired Daily Rate : ").append(desiredDailyRate).append("\n");
        result.append("Duration Of Engagment : ").append(durationOfEngagmentInDays).append(" days\n");
        return result.toString();
    }
}
