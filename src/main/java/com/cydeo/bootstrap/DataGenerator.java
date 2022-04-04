package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//This will generate the data before the run
@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService){
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(1L,"Manager");
        RoleDTO employeeRole = new RoleDTO(1L,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John","Kesty","johnketsy@mailinator.com","thispass",true,"7484847242",managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Amy","Spring","amyspring@mail.com","amypass",true,"7484847242",adminRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Clair","Orange","clairorange@mail.com","clairpass",true,"7484847242",employeeRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Marissa","Owen","marissaowen@mail.com","marissapass",true,"7484847242",employeeRole, Gender.FEMALE);
        UserDTO user5 = new UserDTO("Adam","Eve","adameve@mail.com","adamapass",true,"7484847242",employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(), LocalDate.now().plusDays(25),"Creating Controller", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(), LocalDate.now().plusDays(10),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user3, LocalDate.now(), LocalDate.now().plusDays(25),"Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);
    }
}
