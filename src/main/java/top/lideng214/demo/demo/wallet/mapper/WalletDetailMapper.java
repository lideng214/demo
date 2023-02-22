package top.lideng214.demo.demo.wallet.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.lideng214.demo.demo.wallet.model.WalletDetail;
import top.lideng214.demo.demo.wallet.vo.WalletDetailVO;

import java.util.List;
import java.util.Map;

/**
* @author lideng
* @description 针对表【wallet_detail(钱包明细)】的数据库操作Mapper
* @createDate 2023-02-21 15:33:08
* @Entity top.lideng214.demo.demo.wallet.model.WalletDetail
*/
@Mapper
public interface WalletDetailMapper extends BaseMapper<WalletDetail> {

    /**
     * 多条件查询
     * @param map 查询条件
     * @return 查询结果
     */
    List<WalletDetailVO> findAllByMap(@Param("paramMap") Map<String,Object> map);
}
