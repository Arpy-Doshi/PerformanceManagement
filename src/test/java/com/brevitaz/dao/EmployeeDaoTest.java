package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeDaoTest
{
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void createTest() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Arpy");
        employee.setDepartment("Developing");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);
    }


    @Test
    public void getByIdTest()  {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("Yash");
        employee.setDepartment("Developing");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        employee = employeeDao.getById("2");
        Assert.assertNotNull(employee);
    }

    @Test
    public void updateTest(){
        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("Anushka");
        employee.setDepartment("Developing");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        employee.setName("Anoushka");

        boolean status1 = employeeDao.update(employee,"3");
        Assert.assertEquals(true,status1);
    }


    @Test
    public void getAllTest() {
        Employee employee = new Employee();
        employee.setId("4");
        employee.setName("Pr");
        employee.setDepartment("Developing");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        List<Employee> employees = employeeDao.getAll();
        Assert.assertNotNull(employees);
    }

    @Test
    public void deleteTest(){

        Employee employee = new Employee();
        employee.setId("5");
        employee.setName("Adhi");
        employee.setDepartment("Developing");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        boolean status1=employeeDao.delete("5");
        Assert.assertEquals(true,status1);
    }


}
