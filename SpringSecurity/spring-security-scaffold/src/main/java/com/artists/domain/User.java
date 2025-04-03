    package com.artists.domain;

    import com.baomidou.mybatisplus.annotation.TableId;
    import com.baomidou.mybatisplus.annotation.TableName;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import java.util.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @TableName("USER")
    public class User {
        private static final long serialVersionUID = -40356785423868312L;

        @TableId
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
        private String phoneNumber;
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
        private String userId;

        private String createTime;
        private String updateTime;
    }
