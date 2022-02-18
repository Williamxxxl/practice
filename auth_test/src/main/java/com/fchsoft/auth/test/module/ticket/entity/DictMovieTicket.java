package com.fchsoft.auth.test.module.ticket.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author qw
 * @since 2022-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DictMovieTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String movieName;

    private BigDecimal ticketPrice;

    private Integer ticketTotal;

    private Date lastSellTime;

    private String lastSellPerson;


}
