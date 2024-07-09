package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-09 14:15:27
 * @description
 */
@Data
@TableName("profession")
public class ProfessionEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -98553077520491894L;
    /**
     * 主键
     */
    @TableField("id")
    private Long id;
    /**
     * 上级节点ID
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 专业名称
     */
    @TableField("profession_name")
    private String professionName;
    /**
     * 专业编码
     */
    @TableField("profession_code")
    private String professionCode;
    /**
     * 专业等级
     */
    @TableField("level")
    private Integer level;
    /**
     * 状态
     */
    @TableField("status")
    private Integer status;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 到期时间
     */
    @TableField("order_time")
    private LocalDateTime orderTime;
    /**
     * 到期标签（0到期，1未到期）
     */
    @TableField("order_type")
    private Integer orderType;
    /**
     * 是否删除
     */
    @TableField("is_delete")
    private Integer isDelete;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 修改人
     */
    @TableField("updator")
    private String updator;
}

