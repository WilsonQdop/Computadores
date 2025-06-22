package com.github.Wilsonqdop.Gerenciamento.de.pecas.enums;

public enum RoleValues {
    BASIC(2L),
    ADMIN(1L);

    Long roleId;

    RoleValues(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRoleId() {
        return roleId;
    }
}
