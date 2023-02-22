package top.lideng214.demo.demo.wallet.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.lideng214.demo.demo.wallet.model.WalletDetail;
import top.lideng214.demo.demo.wallet.vo.WalletDetailVO;

import java.util.List;
import java.util.Map;

/**
* @author lideng
* @description 针对表【wallet_detail(钱包明细)】的数据库操作Service
* @createDate 2023-02-21 15:33:08
*/
public interface WalletDetailService extends IService<WalletDetail> {
    /**
     * 查询用户钱包金额变动明细
     * @param paramMap 查询参数
     * @return 变动明细
     */
    List<WalletDetailVO> findAllByMap(Map<String,Object> paramMap);
}
