package com.artists.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private static final long serialVersionUID = -40356785423868312L;

    private Long id;
    private String userName;
    private String nickName;
    private String password;
    /**
     * Account Status
     * 0 -> Active
     * 1 -> Deactivate
     */
    private String status;
    private String email;
    private String phonenumber;
    /**
     * 0 -> Female
     * 1 -> Male
     */
    private String sex;
    private String avatar;
    /**
     * 0 -> Administrator
     * 1 -> User
     */
    private String userType;
    /**
     * The uid of creator
     */
    private Long createBy;
    private Date createTime;
    /**
     * The uid of who update user details
     */
    private Long updateBy;
    private Long updateTime;
    /**
     * 0 -> Not del
     * 1 -> Del
     */
    private Integer delFlag;
}
