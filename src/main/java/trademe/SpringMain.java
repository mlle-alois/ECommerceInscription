package trademe;

import trademe.application.command.*;
import trademe.application.query.RetrieveUser;
import trademe.application.query.RetrieveUserHandler;
import trademe.domain.Contractor;
import trademe.domain.GeographicZone;
import trademe.domain.Tradesman;
import trademe.domain.enums.AptitudeCertificates;
import trademe.domain.enums.Department;
import trademe.domain.enums.Skills;
import trademe.domain.enums.Speciality;
import trademe.domain.valueObjects.DailyRate;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;
import trademe.exposition.PasswordResponse;
import trademe.kernel.exceptions.UnavailableEmailException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create Tradesman
        RegisterTradesmanCommandHandler registerTradesmanCommandHandler = applicationContext.getBean(RegisterTradesmanCommandHandler.class);
        RegisterTradesman registerCarpenter = new RegisterTradesman(UserMail.of("b@g.com"), "DUPONT", "BERNARD",
                Password.of("my_first_password"), Speciality.CARPENTER,
                new ArrayList<>() {{
                    add(AptitudeCertificates.BEP_CARPENTER);
                }},
                new ArrayList<>() {{
                    add(Skills.ABLE_TO_TRAIN_AND_ADVISE);
                    add(Skills.BENDING);
                    add(Skills.COATING);
                    add(Skills.FORMWORK);
                }},
                GeographicZone.of(new ArrayList<>() {{
                    add(Department.ESSONNE_91);
                }}),
                DailyRate.of(120));
        final UserId carpenterId = registerTradesmanCommandHandler.handle(registerCarpenter);

        RetrieveUserHandler retrieveUserHandler = applicationContext.getBean(RetrieveUserHandler.class);
        Tradesman carpenter = (Tradesman) retrieveUserHandler.handle(new RetrieveUser(carpenterId));
        System.out.println(carpenter.toString());

        //--2. Create Contractor
        RegisterContractorCommandHandler registerContractorCommandHandler = applicationContext.getBean(RegisterContractorCommandHandler.class);
        RegisterContractor registerContractor = new RegisterContractor(UserMail.of("contractor@g.com"), "POTIER", "LUCIE", Password.of("my_password"));
        final UserId contractorId = registerContractorCommandHandler.handle(registerContractor);

        Contractor contractor = (Contractor) retrieveUserHandler.handle(new RetrieveUser(contractorId));
        System.out.println(contractor.toString());

        //--3. Modify Tradesman Password
        ModifyUserPasswordCommandHandler modifyUserPasswordCommandHandler = applicationContext.getBean(ModifyUserPasswordCommandHandler.class);
        modifyUserPasswordCommandHandler.handle(new ModifyUserPassword(carpenterId.getValue(), new PasswordResponse("my_new_password")));

        carpenter = (Tradesman) retrieveUserHandler.handle(new RetrieveUser(carpenterId));
        System.out.println(carpenter.toString());

        //--4. Login users
        LoginUser loginCarpenter = new LoginUser(carpenter.getUserMail(), carpenter.getPassword());
        LoginUserCommandHandler loginUserCommandHandler = applicationContext.getBean(LoginUserCommandHandler.class);
        loginUserCommandHandler.handle(loginCarpenter);

        LoginUser loginContractor = new LoginUser(contractor.getUserMail(), contractor.getPassword());
        loginUserCommandHandler.handle(loginContractor);

        //--5. Logout users
        LogoutUser logoutCarpenter = new LogoutUser(carpenter.getId());
        LogoutUserCommandHandler logoutUserCommandHandler = applicationContext.getBean(LogoutUserCommandHandler.class);
        logoutUserCommandHandler.handle(logoutCarpenter);

        LogoutUser logoutContractor = new LogoutUser(contractor.getId());
        logoutUserCommandHandler.handle(logoutContractor);
    }
}
