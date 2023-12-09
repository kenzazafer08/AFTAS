package com.example.aftas.controller;

import com.example.aftas.dto.LevelReq;
import com.example.aftas.dto.LevelResp;
import com.example.aftas.dto.MemberReq;
import com.example.aftas.dto.MemberResp;
import com.example.aftas.exception.ResourceNotFoundException;
import com.example.aftas.services.interfaces.MemberServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberServiceInterface memberService;

    @Autowired
    public MemberController(MemberServiceInterface memberService) {
        this.memberService = memberService;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleMemberNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<MemberResp>> addMember(@Valid @RequestBody MemberReq member){
        Optional<MemberResp> memberSaved = memberService.AddMember(member);
        return ResponseEntity.ok(memberSaved);
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResp> findById(@PathVariable Long id){
        Optional<MemberResp> member = memberService.findById(id);
        return ResponseEntity.ok(member.get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<MemberResp>> getAllMembers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<MemberResp> members = memberService.getAllMembers(page,size);
        return ResponseEntity.ok(members);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<MemberResp>> deleteMember(@PathVariable Long id){
        Optional<MemberResp> member = memberService.deleteMember(id);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/update/{memberNum}")
    public ResponseEntity<Optional<MemberResp>> updateLevel(
            @PathVariable Long memberNum,
            @Valid @RequestBody MemberReq member
    ){
        Optional<MemberResp> updatedMember = memberService.updateMember(memberNum,member);
        return ResponseEntity.ok(updatedMember);
    }

}
