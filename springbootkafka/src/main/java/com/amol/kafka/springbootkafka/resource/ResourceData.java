package com.amol.kafka.springbootkafka.resource;

import com.amol.kafka.springbootkafka.model.Department;
import com.amol.kafka.springbootkafka.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class ResourceData {
    @Autowired
    KafkaTemplate<String, Department> kafkaTemplate;
    @Autowired
    KafkaTemplate<String, Employee> kafkaTemplateemployee;
    private static final String employeeTOPIC = "employeeDataTopic";
    private static final String departmentTOPIC = "departmentDataTopic";

    @PostMapping("/publish/department")
    public String post(@RequestBody Department department)
    {
        //  Get request charge and other properties like latency, and diagnostics strings, etc.
        kafkaTemplate.send(departmentTOPIC, department);
        return "Publish department Successfully";
    }
    @PostMapping("/publish/employee")
    public String post(@RequestBody Employee employee)
    {
        //  Get request charge and other properties like latency, and diagnostics strings, etc.
        kafkaTemplateemployee.send(employeeTOPIC, employee);
        return "Publish employee Successfully";
    }
}
