package com.cretus.soapweb;

import com.cretus.courses.CourseDetails;
import com.cretus.courses.GetCourseDetailsRequest;
import com.cretus.courses.GetCourseDetailsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
class CourseDetailsEndpoint {
    @Autowired
    CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace = "http://cretus.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        Course course = courseDetailsService.findById(request.getId());
        if(course == null){
            throw new CourseNotFoundException("Invalid course id"+request.getId());
        }
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        response.setCourseDetails(courseDetails);
        return response;
    }
}