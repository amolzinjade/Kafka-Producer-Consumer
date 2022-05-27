package com.amol.kafka.springbootkafka.listener;


import com.amol.kafka.springbootkafka.model.Department;
import com.amol.kafka.springbootkafka.model.Employee;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

import java.io.*;


@Service
public class KafkaConsumerListener {

    //Below method will get use to consume department data
    @KafkaListener(topics="departmentDataTopic",groupId = "group_json", containerFactory = "departmentConcurrentKafkaListenerContainerFactory")
    public void consumedepartmentJson(Department department){
        try
        {

            System.out.println("Consumed Json message:"+ department);
            final String storageConnectionString = "";
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("swpdata");

            String filename = department.getdeptId();
            filename = filename+".json";
            System.out.println(department.getdeptId());
            File myObj = new File(filename);

            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(new Gson().toJson(department));
            myWriter.close();

            //Write the department data into departmentData directory
            CloudBlobDirectory directory = container.getDirectoryReference("departmentData");
            CloudBlockBlob blob = directory.getBlockBlobReference(filename);
            blob.upload(new FileInputStream(myObj), myObj.length());




        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

    }
    //Below method will get use to consume employee data
    @KafkaListener(topics="employeeDataTopic",groupId = "group_json", containerFactory = "employeeConcurrentKafkaListenerContainerFactory")
    public void consumeemployeeJson(Employee employee){
        try
        {
            System.out.println("Consumed Json message:"+ employee);
            final String storageConnectionString = "";
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the blob client.
            CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

            // Retrieve reference to a previously created container.
            CloudBlobContainer container = blobClient.getContainerReference("swpdata");
            String filename = employee.getemployeeId();

            filename= filename+".json";
            System.out.println(employee.getemployeeId());
            File myObj = new File(filename);

            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(new Gson().toJson(employee));
            myWriter.close();

            //Write the employee data into main container
            CloudBlockBlob blob = container.getBlockBlobReference(filename);
            blob.upload(new FileInputStream(myObj), myObj.length());




            CloudBlobDirectory directory1 = container.getDirectoryReference("departmentData");
            //next is in try/catch
            Iterable<ListBlobItem> fileBlobs = directory1.listBlobs();
            for (ListBlobItem fileBlob : fileBlobs) {
                if (fileBlob instanceof CloudBlob) {
                    CloudBlob cloudBlob = (CloudBlob) fileBlob;
                    System.out.println("Blob="+cloudBlob.getName());
                    CloudBlockBlob blob1 = container.getBlockBlobReference("employeeData\\"+ employee.getemployeeId()+"\\"+cloudBlob.getName());

                    blob1.upload(new FileInputStream(myObj), myObj.length());

                }
            }


        }
        catch (Exception e)
        {
            // Output the stack trace.
            e.printStackTrace();
        }

    }
}
