package trademe.domain;

import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.util.ArrayList;
import java.util.List;

public final class Contractor extends User {

    private final List<Project> projects;

    private Contractor(UserId userId, UserMail userMail, String lastname, String firstname, Password password) {
        super(userId, userMail, lastname, firstname, password);
        this.projects = new ArrayList<>();
    }

    public static Contractor of(UserId userId, UserMail userMail, String lastname, String firstname, Password password) {
        return new Contractor(userId, userMail, lastname, firstname, password);
    }

    public List<Project> getConstructProjects() {
        return projects;
    }

    public String toStringProjects() {
        StringBuilder result = new StringBuilder();
        for (Project project : projects) {
            result.append("------------ Project : \n").append(project.toString()).append("\n");
        }
        return result.toString();
    }
}
