package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performance")
public class PerformanceManagementController
{
    @RequestMapping(value = "",method = RequestMethod.POST)
    public void insert(@RequestBody Employee employee) throws Exception
    {
        System.out.println("Assessment form is filled!!!");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void update(@RequestBody Employee employee , @PathVariable String id) throws Exception
    {
        System.out.println("Assessment form is updated!!!");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public void getById(@PathVariable String id) throws Exception
    {
        System.out.println("Assessment form is viewed!!!");
    }


}
