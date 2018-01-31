package org.anowls.sys

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import tk.mybatis.spring.annotation.MapperScan

/**
 * <p>Title: sys_platform</p>
 * <p>Description: 程序入口</p>
 * <p>Copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved</p>
 * <p>Company: http://www.hanboard.com</p>
 *
 * @author haopeisong
 * @date 2018/1/26 0026
 */
@SpringBootApplication
@MapperScan(basePackages = SysApplication.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
class SysApplication {

    static final String PACKAGE = "org.anowls.sys.mapper"

    static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args)
    }
}
