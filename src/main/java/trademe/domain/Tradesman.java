package trademe.domain;

import trademe.domain.enums.AptitudeCertificates;
import trademe.domain.enums.Skills;
import trademe.domain.enums.Speciality;
import trademe.domain.valueObjects.DailyRate;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.util.List;
import java.util.Objects;

public final class Tradesman extends User {

    private final Speciality speciality;
    private final List<AptitudeCertificates> aptitudeCertificates;
    private final List<Skills> skills;
    private final GeographicZone geographicZone;
    private final DailyRate dailyRate;

    private Tradesman(UserId userId, UserMail userMail, String lastname, String firstname,
                      Password password, Speciality speciality, List<AptitudeCertificates> aptitudeCertificates,
                      List<Skills> skills, GeographicZone geographicZone, DailyRate dailyRate) {
        super(userId, userMail, lastname, firstname, password);
        this.speciality = Objects.requireNonNull(speciality);
        this.aptitudeCertificates = Objects.requireNonNull(aptitudeCertificates);
        this.skills = Objects.requireNonNull(skills);
        this.geographicZone = Objects.requireNonNull(geographicZone);
        this.dailyRate = Objects.requireNonNull(dailyRate);
    }

    public static Tradesman of(UserId userId, UserMail userMail, String lastname, String firstname,
                               Password password, Speciality speciality, List<AptitudeCertificates> aptitudeCertificates,
                               List<Skills> skills, GeographicZone geographicZone, DailyRate dailyRate) {
        return new Tradesman(userId, userMail, lastname, firstname, password, speciality, aptitudeCertificates, skills, geographicZone, dailyRate);
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public List<AptitudeCertificates> getAptitudeCertificates() {
        return aptitudeCertificates;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public GeographicZone getGeographicZone() {
        return geographicZone;
    }

    public DailyRate getDailyRate() {
        return dailyRate;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n");
        result.append("-- Aptitude certificates : \n");
        for (AptitudeCertificates aptitudeCertificate : aptitudeCertificates) {
            result.append(aptitudeCertificate).append("\n");
        }
        result.append("-- Skills : \n").append(toStringSkills()).append("\n");
        result.append("-- Geographic zone : \n").append(geographicZone.toString()).append("\n");
        result.append("-- Daily rate : ").append(dailyRate.toString()).append("\n");
        return result.toString();
    }

    public String toStringSkills() {
        StringBuilder result = new StringBuilder();
        for (Skills skill : skills) {
            result.append("- ").append(skill).append("\n");
        }
        return result.toString();
    }
}
