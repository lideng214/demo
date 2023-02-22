package top.lideng214.demo.demo.wallet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lideng214.demo.demo.wallet.mapper.WalletDetailMapper;
import top.lideng214.demo.demo.wallet.model.WalletDetail;
import top.lideng214.demo.demo.wallet.service.WalletDetailService;
import top.lideng214.demo.demo.wallet.vo.WalletDetailVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
* @author lideng
* @description 针对表【wallet_detail(钱包明细)】的数据库操作Service实现
* @createDate 2023-02-21 15:33:08
*/
@Service
public class WalletDetailServiceImpl extends ServiceImpl<WalletDetailMapper, WalletDetail>
implements WalletDetailService {

    @Resource
    private WalletDetailMapper walletDetailMapper;

    @Override
    public List<WalletDetailVO> findAllByMap(Map<String, Object> paramMap) {
        return walletDetailMapper.findAllByMap(paramMap);
    }
}
