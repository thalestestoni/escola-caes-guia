package hkeller.escolacaesguia.user.dtos;

import java.util.List;

public class CreateUserRoleDto {
    private Long userId;
    private List<Long> roleIds;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public List<Long> getRoleIds() {
        return this.roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
