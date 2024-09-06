package com.flint.weather.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> exception(Exception exception){
//        log.error(exception.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(exception.getMessage()));
//    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public String exception(Exception exception, RedirectAttributes redirectAttributes, HandlerMethod handlerMethod){
//        String className = handlerMethod.getBeanType().getSimpleName();
//        String methodName = handlerMethod.getMethod().getName();
//        redirectAttributes.addFlashAttribute("error", new ErrorMessage("Class name: " + className + " \nMessage: " + exception.getMessage()));
//        log.error(exception.getMessage());
//        return "redirect:/location/saved";
//    }

}
