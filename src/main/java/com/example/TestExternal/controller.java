package com.example.TestExternal;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Service
@RestController
@RequestMapping("/test")
public class controller {
    @GetMapping("/500error")
    private void internalServerError () {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "500 Internal Server Error");
    }

    @GetMapping("/200-success")
    private String success () {
        return "success";
    }

    @GetMapping("/201-created")
    private void created () {
        throw new ResponseStatusException(HttpStatus.CREATED, "201 CREATED");
    }

    @GetMapping("/202-accepted")
    private void accepted () {
        throw new ResponseStatusException(HttpStatus.ACCEPTED, "202 ACCEPTED");
    }

    @GetMapping("/204-no-content")
    private void noContent () {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "204 NO_CONTENT");
    }

    @GetMapping("/304-notmodified")
    private void notModified () {
        throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "304 NOT_MODIFIED");
    }

    @GetMapping("/400error")
    private void badRequestError () {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "400 BAD_REQUEST");
    }

    @GetMapping("/403error")
    private void fobidenError () {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "403 FORBIDDEN");
    }

    @GetMapping("/404error")
    private void notfoundError () {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 NOT_FOUND");
    }

    @GetMapping("/502error")
    private void badGateWayError () {
        throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "502 BAD_GATEWAY");
    }

    @GetMapping("/503error")
    private void serviceUnavailableError () {
        throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "503 SERVICE_UNAVAILABLE");
    }

    @GetMapping("/504error")
    private void gatewayTimeoutError () {
        throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT, "504 GATEWAY_TIMEOUT");
    }


}
