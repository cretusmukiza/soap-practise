package com.cretus.soapweb;

import java.util.List;

import com.cretus.courses.CourseDetails;
import com.cretus.courses.GetAllCourseDetailsRequest;
import com.cretus.courses.GetAllCourseDetailsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GetAllCourseDetailsEndpoint {
    
    @Autowired
    CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace = "http://cretus.com/courses",localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        List<Course> courses = courseDetailsService.findAll();
        for(Course course: courses){
            CourseDetails mapCourse = new CourseDetails();
            mapCourse.setId(course.getId());
            mapCourse.setName(course.getName());
            mapCourse.setDescription(course.getDescription());
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }
}
