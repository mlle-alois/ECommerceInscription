package trademe;

import trademe.domain.Contractor;
import trademe.domain.Project;
import trademe.domain.Task;
import trademe.domain.enums.Department;
import trademe.domain.valueObjects.DailyRate;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Calendar;

public final class Main {
    public static void main(String[] args) {

        Calendar start = Calendar.getInstance();
        start.set(2021, Calendar.AUGUST, 22);
        Calendar end = Calendar.getInstance();
        end.set(2022, Calendar.AUGUST, 22);
        Project project = Project.of("p", Contractor.of(UserId.of(1), UserMail.of("x"), "x", "x",
                Password.of("x")), new ArrayList<Task>(), start, end, Department.ESSONNE_91, DailyRate.of(250), 10);

        System.out.println(project.toString());
    }
}
