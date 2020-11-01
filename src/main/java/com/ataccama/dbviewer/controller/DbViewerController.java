package com.ataccama.dbviewer.controller;

import com.ataccama.dbviewer.model.DbDetail;
import com.ataccama.dbviewer.service.DbViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/details", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DbViewerController {

    @Autowired
    DbViewerService dbViewerService;

    @GetMapping(path = "/all")
    public Iterable<DbDetail> getAllDetails() {
        return dbViewerService.findAll();
    }

    @PostMapping("/save")
    DbDetail save(@RequestBody DbDetail detail) {
        return dbViewerService.save(detail);
    }

    @GetMapping("/get/{id}")
    DbDetail getDbDetailById(@PathVariable Long id) {
        return dbViewerService.getDbDetailById(id);
    }

    @PutMapping("/update/{id}")
    public DbDetail updateDbDetail(@RequestBody DbDetail newDetail, @PathVariable Long id) {
        return dbViewerService.updateDbDetail(newDetail, id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteDbDetail(@PathVariable Long id) {
        dbViewerService.deleteById(id);
    }

}
