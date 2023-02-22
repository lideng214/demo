package top.lideng214.demo.demo.wallet.util;

/**
 * @author lideng
 * @date 2023/2/21 17:03 星期二
 * 钱包余额变动类型
 */
public enum WalletDetailType {
    /**
     * 退款
     */
    REFUND("退款",5),
    /**
     * 消费
     */
    CONSUME("消费",8)
    ;
    WalletDetailType(String name,Integer code){
        this.name = name;
        this.code = code;
    }
    private String name;
    private Integer code;

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
