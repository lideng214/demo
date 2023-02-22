package top.lideng214.demo.demo.wallet.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lideng
 * @date 2023/2/21 16:14 星期二
 */
@Data
public class WalletDetailVO {
    /**
     * 变动类型
     */
    private Integer type;

    /**
     * 变动金额
     */
    private BigDecimal money;

    /**
     * 变动前金额
     */
    private BigDecimal oldMoney;

    /**
     * 变动后金额
     */
    private BigDecimal newMoney;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String creater;
}
