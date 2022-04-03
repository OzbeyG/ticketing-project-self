package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;

//This will generate the data before the run
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;


    public DataGenerator(RoleService roleService, UserService userService){
        this.roleService = roleService;
        this.userService = userService;
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
    }
}
