package com.brevitaz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PerformanceManagementFormController
{
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void create() throws Exception
    {
        System.out.println("Assessment form is created by HR!!!");
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public void update() throws Exception
    {
        System.out.println("Assessment form is updated by HR!!!");
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public void delete() throws Exception
    {
        System.out.println("Assessment form is deleted by HR!!!");
    }

}
