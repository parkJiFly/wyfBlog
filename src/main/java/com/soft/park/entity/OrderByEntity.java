package com.soft.park.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-09 14:16:04
 * @description
 */
@Data
@TableName("order_by")
public class OrderByEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -89329254888899569L;
    /**
     * 主键
     */
    @TableField("id")
    private Long id;
    /**
     * 到期主键
     */
    @TableField("order_id")
    private Long orderId;
}

