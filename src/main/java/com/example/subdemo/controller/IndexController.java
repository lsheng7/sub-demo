package com.example.subdemo.controller;

import com.example.subdemo.bean.dto.IndexDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Api(tags = "首页模块")
@RequestMapping("/index")
@RestController
public class IndexController {

    //content-type: application/x-www-form-urlencoded
    @ApiOperation(value = "get-demo")
    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    //content-type: application/json
    @ApiOperation(value = "post-body-demo")
    @PostMapping("/post/body")
    public ResponseEntity<String> postBody(@RequestBody IndexDto indexDto) {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return ResponseEntity.ok("Hi:" + indexDto);
    }

    //content-type: multipart/form-data; boundary=----WebKitFormBoundaryYTiRAJANUj6Ahdzb
    @ApiOperation(value = "post-image-demo")
    @PostMapping("/post/image")
    public ResponseEntity<String> postImage(@RequestParam("image") MultipartFile image) {
        return ResponseEntity.ok("Hi:" + image.getName());
    }

    //content-type: multipart/form-data; boundary=----WebKitFormBoundaryYTiRAJANUj6Ahdzb
    @ApiOperation(value = "post-file-demo")
    @PostMapping("/post/file")
    public ResponseEntity<String> postIFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("Hi:" + file.getName());
    }


    @ApiOperation(value = "get-list")
    @GetMapping("/get/list")
    public ResponseEntity<List<String>> getList() {
        return ResponseEntity.ok(Arrays.asList("a", "b", "c"));
    }

    @ApiOperation(value = "get-array")
    @GetMapping("/get/array")
    public ResponseEntity<String[]> getArray() {
        return ResponseEntity.ok(new String[]{"a", "c"});
    }
}
