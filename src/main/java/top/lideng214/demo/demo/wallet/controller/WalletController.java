package top.lideng214.demo.demo.wallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.lideng214.demo.demo.wallet.model.Wallet;
import top.lideng214.demo.demo.wallet.service.WalletDetailService;
import top.lideng214.demo.demo.wallet.service.WalletService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author lideng
 * @date 2023/2/21 15:48 星期二
 * 接口未作权限控制，userId应在系统中获取
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {

    @Resource
    private WalletService walletService;
    @Resource
    private WalletDetailService walletDetailService;

    @ResponseBody
    @PostMapping("getUserMoney")
    public String getUserMoney(Long userId) {
        Wallet wallet = walletService.findUserWallet(userId);
        if (wallet == null) {
            return "未开通钱包";
        }
        return wallet.getMoney().toString();
    }

    /**
     * 用户消费100元接口
     *
     * @param userId 用户id
     * @return 回调信息
     */
    @ResponseBody
    @PostMapping("use100")
    public String userUse100Money(Long userId) {
        boolean useMoney = walletService.userUseMoney(userId, new BigDecimal("100.00"));
        if (!useMoney) {
            // 钱包支付失败使用其他支付方式支付
        }
        return "支付成功";
    }

    /**
     * 用户退款20接口
     *
     * @param userId 用户id
     * @return 回调信息
     */
    @ResponseBody
    @PostMapping("refund20")
    public String userRefund(Long userId) {
        boolean refund = walletService.userRefund(userId, new BigDecimal("20.00"));
        if (!refund) {
            // 退款到钱包失败后，查询是否是为其他方式支付，退款到原渠道
        }
        return "成功";
    }

    /**
     * 查询钱包余额
     *
     * @param map 查询条件
     * @return 查询结果
     */
    @ResponseBody
    @PostMapping("findDetail")
    public Object findWalletDetail(@RequestBody Map<String, Object> map) {
        // 这个地方获取用户id信息然后放进map中
        return walletDetailService.findAllByMap(map);
    }


}
