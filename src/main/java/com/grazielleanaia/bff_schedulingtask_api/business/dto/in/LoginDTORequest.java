package com.grazielleanaia.bff_schedulingtask_api.business.dto.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginDTORequest {

    private String email;

    private String password;

}
