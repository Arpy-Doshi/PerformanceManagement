package com.brevitaz.controller;

import com.brevitaz.model.AssessmentForm;
import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance-form")
public class PerformanceManagementFormController
{
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void create(@RequestBody AssessmentForm assessmentForm) throws Exception
    {
        System.out.println("Assessment form is created by HR!!!");
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void update(@RequestBody AssessmentForm assessmentForm) throws Exception
    {
        System.out.println("Assessment form is updated by HR!!!");
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public void delete() throws Exception
    {
        System.out.println("Assessment form is deleted by HR!!!");
    }

}
