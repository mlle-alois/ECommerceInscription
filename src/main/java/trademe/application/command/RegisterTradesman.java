package trademe.application.command;

import trademe.kernel.Command;
import trademe.domain.GeographicZone;
import trademe.domain.enums.AptitudeCertificates;
import trademe.domain.enums.Skills;
import trademe.domain.enums.Speciality;
import trademe.domain.valueObjects.DailyRate;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserMail;

import java.util.List;
import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class RegisterTradesman implements Command {

    public final UserMail userMail;
    public final String lastname;
    public final String firstname;
    public final Password password;
    public Speciality speciality;
    public List<AptitudeCertificates> aptitudeCertificates;
    public List<Skills> skills;
    public GeographicZone geographicZone;
    public DailyRate dailyRate;

    public RegisterTradesman(UserMail userMail, String lastname, String firstname, Password password,
                             Speciality speciality, List<AptitudeCertificates> aptitudeCertificates,
                             List<Skills> skills, GeographicZone geographicZone, DailyRate dailyRate) {
        this.userMail = Objects.requireNonNull(userMail);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
        this.speciality = Objects.requireNonNull(speciality);
        this.aptitudeCertificates = Objects.requireNonNull(aptitudeCertificates);
        this.skills = Objects.requireNonNull(skills);
        this.geographicZone = Objects.requireNonNull(geographicZone);
        this.dailyRate = Objects.requireNonNull(dailyRate);
    }
}
