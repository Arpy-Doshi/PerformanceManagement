package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.model.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{

    private final String INDEX_NAME = "pm_employee";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(Employee employee)  {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+employee.getId()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= null;
        try {
            indexResponse = client.getClient().index(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<Employee> getAll()  {
        List<Employee> employees = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = null;
        try {
            response = client.getClient().search(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchHit[] hits = response.getHits().getHits();

        Employee employee = null;

        for (SearchHit hit : hits)
        {
            try {
                employee = objectMapper.readValue(hit.getSourceAsString(), Employee.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            employees.add(employee);
        }
        return employees;

    }

    @Override
    public boolean update(Employee employee,String id) {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = null;
        try {
            updateRequest = new UpdateRequest(
                    INDEX_NAME,TYPE_NAME,
                    id).doc(objectMapper.writeValueAsString(employee), XContentType.JSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        UpdateResponse updateResponse = null;
        try {
            updateResponse = client.getClient().update(updateRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String id)  {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        DeleteResponse response = null;
        try {
            response = client.getClient().delete(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public Employee getById(String id) {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        GetResponse getResponse = null;
        try {
            getResponse = client.getClient().get(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        Employee employee  = null;
        try {
            employee = objectMapper.readValue(getResponse.getSourceAsString(),Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(employee);
        return employee;
    }

}
