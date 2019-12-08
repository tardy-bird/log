package com.tardybird.log.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author nick
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogVo {
    private Integer adminId;
    private String ip;
    private Integer type;
    private String action;
    private Integer statusCode;
    private Integer actionId;
}
