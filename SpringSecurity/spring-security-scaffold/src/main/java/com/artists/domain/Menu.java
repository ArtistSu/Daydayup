package com.artists.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value="sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
    private static final long serialVersionUID =-54979041104113736L;

    @TableId
    private Long id;

    private String menuName;

    private String path;

    private String component;

    private String visible;

    private String status;

    private String perms;

    private String icon;

    private String createTime;

    private String updateTime;
}

