package com.cydeo.converter;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.core.convert.converter.Converter;

public class ProjectDtoConverter implements Converter<String, ProjectDTO> {

    ProjectService projectService;

    //injection
    public ProjectDtoConverter(ProjectService projectService){
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source){
        return projectService.findById(source);
    }
}
