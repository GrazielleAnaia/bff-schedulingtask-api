package com.grazielleanaia.bff_schedulingtask_api.business.dto.out;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class ViaCepDTOResponse {
    public String cep;
    public String logradouro;
    public String complemento;
    public String unidade;
    public String bairro;
    public String localidade;
    public String uf;
    public String estado;
    public String regiao;
    public String ibge;
    public String gia;
    public String ddd;
    public String siafi;

}
