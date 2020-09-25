package com.amarsoft.ysshao.controller;

import com.amarsoft.ysshao.exception.ErrorResponse;
import com.amarsoft.ysshao.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ysshao
 * @create 2020-05-03 22:00
 */

@ControllerAdvice(assignableTypes = { ExceptionController.class})
@RestController
public class ExceptionController {

    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourseNotFoundResponse = new ErrorResponse(new ResourceNotFoundException("Sorry, the resourse not found!"));

}
