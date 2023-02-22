package top.lideng214.demo.demo.wallet.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lideng214.demo.demo.wallet.mapper.WalletMapper;
import top.lideng214.demo.demo.wallet.model.Wallet;
import top.lideng214.demo.demo.wallet.model.WalletDetail;
import top.lideng214.demo.demo.wallet.service.WalletDetailService;
import top.lideng214.demo.demo.wallet.service.WalletService;
import top.lideng214.demo.demo.wallet.util.WalletDetailType;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


/**
* @author lideng
* @description 针对表【wallet(钱包表)】的数据库操作Service实现
* @createDate 2023-02-21 15:33:08
*/
@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet>
implements WalletService {

    @Resource
    private WalletMapper walletMapper;
    @Resource
    private WalletDetailService walletDetailService;
    @Override
    public Wallet findUserWallet(Long userId) {
        return walletMapper.findByUserIdWallet(userId);
    }

    @Override
    public boolean userUseMoney(Long userId, BigDecimal money) {
        Wallet wallet = findUserWallet(userId);
        if (wallet == null){
            log.warn("用户("+userId+")钱包信息为空！");
            return false;
        }
        BigDecimal userMoney = wallet.getMoney();
        // 判断钱包余额是否足够本次消费
        if (userMoney.compareTo(money) < 0){
            return false;
        }
        BigDecimal subtract = userMoney.subtract(money);
        WalletDetail walletDetail = assembleDetail(wallet, WalletDetailType.CONSUME, money, subtract);
        // 保存消费记录，更新钱包余额
        walletDetailService.save(walletDetail);
        wallet.setMoney(subtract);
        updateById(wallet);
        return true;
    }

    @Override
    public boolean userRefund(Long userId, BigDecimal money) {
        Wallet wallet = findUserWallet(userId);
        if (wallet == null){
            log.warn("用户("+userId+")钱包信息为空！");
            return false;
        }
        // 此处添加判断退款是否合理的代码
        BigDecimal userMoney = wallet.getMoney();
        BigDecimal add = userMoney.add(money);

        // 保存消费记录，更新钱包余额
        WalletDetail walletDetail = assembleDetail(wallet, WalletDetailType.REFUND, money, add);
        walletDetailService.save(walletDetail);
        wallet.setMoney(add);
        updateById(wallet);
        return true;
    }

    /**
     * 重复使用的代码片段 组装一个钱包变动明细
     * @param wallet 钱包信息
     * @param type 变动类型
     * @param money 变动金额
     * @param newMoney 变动后的金额
     * @return 组装好的变动明细
     */
    private WalletDetail assembleDetail(Wallet wallet,WalletDetailType type,BigDecimal money,BigDecimal newMoney){
        WalletDetail walletDetail = new WalletDetail();
        walletDetail.setWalletId(wallet.getId());
        walletDetail.setUserId(wallet.getUserId());
        walletDetail.setOldMoney(wallet.getMoney());
        walletDetail.setNewMoney(newMoney);
        walletDetail.setMoney(money);
        walletDetail.setCreateTime(new Date());
        walletDetail.setType(type.getCode());
        return walletDetail;
    }
}
