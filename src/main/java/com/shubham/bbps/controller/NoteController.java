package com.shubham.bbps.controller;

import com.shubham.bbps.exception.ResourceNotFoundException;
import com.shubham.bbps.model.Note;
import com.shubham.bbps.repository.NoteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@RestController
@RequestMapping("/api")
@Api(value = "This is BBPS HDFC API Documentation", description = "This API provides the capability to search Payu Payment from a HDFC Repository", produces = "application/json")
public class NoteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(com.shubham.bbps.controller.NoteController.class);
	
    @Autowired
    NoteRepository noteRepository;

    @ApiOperation(value = "Return Fetch Notes Data", produces = "application/json")
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
    	LOGGER.info("inside notes get");
        return noteRepository.findAll();
    }

    @ApiOperation(value = "Submit Notes Data", produces = "application/json")
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
    	LOGGER.info("inside notes post");
        return noteRepository.save(note);
    }

    @ApiOperation(value = "Return Fetch Notes Data based on id", produces = "application/json")
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
    	LOGGER.info("inside getNoteById "+noteId);
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @ApiOperation(value = "Update Notes Data", produces = "application/json")
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {

    	LOGGER.info("inside updateNote "+noteId);
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @ApiOperation(value = "Delete Fetch Notes Data", produces = "application/json")
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
    	LOGGER.info("inside deleteNote "+noteId);
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
