/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.cms.dto;
import cn.zhuatech.cms.model.UserAccount; import jakarta.validation.constraints.NotBlank;
public final class AuthDto {
    private AuthDto(){}
    public record LoginRequest(@NotBlank(message="请输入用户名") String username,@NotBlank(message="请输入密码") String password){}
    public record UserView(Long id,String username,String fullName,String role,String siteCode){
        public static UserView from(UserAccount u){return new UserView(u.getId(),u.getUsername(),u.getFullName(),u.getRole().name(),u.getSiteCode());}
    }
    public record LoginResponse(String token,UserView user){}
}
