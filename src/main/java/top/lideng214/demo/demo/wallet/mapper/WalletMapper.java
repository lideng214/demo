package top.lideng214.demo.demo.wallet.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.lideng214.demo.demo.wallet.model.Wallet;

/**
* @author lideng
* @description 针对表【wallet(钱包表)】的数据库操作Mapper
* @createDate 2023-02-21 15:33:08
* @Entity wallet.model.Wallet
*/
@Mapper
public interface WalletMapper extends BaseMapper<Wallet> {

    /**
     * 查询用户钱包详情
     * @param userId 用户id
     * @return 钱包详情
     */

    Wallet findByUserIdWallet(Long userId);
}
