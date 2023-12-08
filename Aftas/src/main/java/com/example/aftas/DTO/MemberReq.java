package com.example.aftas.DTO;

import com.example.aftas.Entity.IdentityDocumentType;
import lombok.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberReq {
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Family name is required")
    private String familyName;
    @NotEmpty(message = "Nationality is required")
    private String nationality;
    @NotNull
    private IdentityDocumentType IdentityDocument;
    @NotNull
    private String IdentityNumber;
}
