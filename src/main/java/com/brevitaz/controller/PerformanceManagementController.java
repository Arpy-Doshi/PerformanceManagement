package com.brevitaz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance")
public class PerformanceManagementController
{
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void insert() throws Exception
    {
        System.out.println("Assessment form is filled!!!");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void update(@PathVariable String id) throws Exception
    {
        System.out.println("Assessment form is updated!!!");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public void getById(@PathVariable String id) throws Exception
    {
        System.out.println("Assessment form is viewed!!!");
    }

    @RequestMapping(value = "/createForm",method = RequestMethod.POST)
    public void createForm() throws Exception
    {
        System.out.println("Assessment form is created by HR!!!");
    }

    @RequestMapping(value = "/updateForm",method = RequestMethod.PUT)
    public void updateAssessmentForm() throws Exception
    {
        System.out.println("Assessment form is updated by HR!!!");
    }

    @RequestMapping(value = "/deleteForm",method = RequestMethod.DELETE)
    public void deleteAssessmentForm() throws Exception
    {
        System.out.println("Assessment form is deleted by HR!!!");
    }

}
