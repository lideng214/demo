package top.lideng214.demo.demo.wallet.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.lideng214.demo.demo.wallet.model.Wallet;

import java.math.BigDecimal;

/**
* @author lideng
* @description 针对表【wallet(钱包表)】的数据库操作Service
* @createDate 2023-02-21 15:33:08
*/
public interface WalletService extends IService<Wallet> {
    /**
     * 查询用户钱包余额
     * @param userId 用户id
     * @return 当前余额
     */
    Wallet findUserWallet(Long userId);

    /**
     * 用户消费接口
     * @param userId 用户id
     * @param money 消费金额
     * @return 消费成功或失败
     */
    boolean userUseMoney(Long userId,BigDecimal money);

    /**
     * 用户退款接口
     * @param userId 用户id
     * @param money 退款金额
     * @return 退款成功或失败
     */
    boolean userRefund(Long userId,BigDecimal money);




}
