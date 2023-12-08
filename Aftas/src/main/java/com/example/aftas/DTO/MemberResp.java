package com.example.aftas.DTO;

import com.example.aftas.Entity.IdentityDocumentType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResp {
    private String name;
    private String familyName;
    private String nationality;
    private LocalDate accessionDate;
    private IdentityDocumentType IdentityDocument;
    private String IdentityNumber;
}
