package com.Wilson.Carrinho.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum Profiles {

    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");

    private Integer code;
    private String role;

    public static Profiles returnRole(Integer code) {

        if(Objects.isNull(code)) {
            return null;
        }

        for(Profiles p : Profiles.values()) {
            if(code.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Perfil inválido");
    }
}
