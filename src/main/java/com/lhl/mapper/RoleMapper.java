package com.lhl.mapper;

        import com.lhl.bean.Role;
        import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    Role getRoleInfo(int sId);
}
