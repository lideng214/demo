package top.lideng214.demo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.lideng214.demo.demo.wallet.mapper.WalletMapper;
import top.lideng214.demo.demo.wallet.model.Wallet;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private WalletMapper walletMapper;

    @Test
    void contextLoads() {

        Wallet wallet1 = walletMapper.findByUserIdWallet(1L);
        System.out.println("wallet1.toString() = " + wallet1.toString());
    }

}
