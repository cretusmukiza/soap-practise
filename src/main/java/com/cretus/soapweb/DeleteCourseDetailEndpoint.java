package com.cretus.soapweb;

import com.cretus.courses.DeleteCourseDetailsRequest;
import com.cretus.courses.DeleteCourseDetailsResponse;
import com.cretus.soapweb.CourseDetailsService.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class DeleteCourseDetailEndpoint {
    @Autowired
    CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace = "http://cretus.com/courses",localPart = "DeleteCourseDetailsRequest")
    @ResponsePayload
    public DeleteCourseDetailsResponse 
        deleteCourseDetailsResponse(@RequestPayload DeleteCourseDetailsRequest request){
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        Status status = courseDetailsService.deleteById(request.getId());
        if(status == Status.FAILURE){
            response.setStatus(com.cretus.courses.Status.FAILURE);
        }
        response.setStatus(com.cretus.courses.Status.SUCCESS);
        return response;
    }

    
}
