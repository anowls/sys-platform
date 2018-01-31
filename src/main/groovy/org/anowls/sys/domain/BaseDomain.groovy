package org.anowls.sys.domain

import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Id

import org.springframework.format.annotation.DateTimeFormat

/**
 * <p>Title: sys-platform</p>
 * <p>Description: 这里填写描述信息</p>
 * <p>Copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved</p>
 * <p>Company: http://www.hanboard.com</p>
 *
 * @author haopeisong
 * @date 2018/1/26 0026
 *
 *  实体域基类
 * 1 实体域字段定义要求：
 * 1) String: VARCHAR,CHAR,TEXT
 * 2) Boolean: BIT
 * 3) Long: INTEGER
 * 4) Integer: TINYINT,SMALLINT,MEDIUMINT
 * 5) BigDecimal: DECIMAL
 * 6) java.sql.Date: DATE,YEAR
 * 7) java.sql.Time: TIME
 * 8) java.sql.Timestamp: DATETIME,TIMESTAMP
 * 2 实体域说明：
 * 1）如果字段名称和数据库一致（忽略大小写），则不需要写@Column注解；如果不一致，则需要写@Column注解。
 * 2) 如果字段名称在数据库中不存在（即扩展出的字段），则需要添加@Transient注解。
 * 3) 如果实体域为数据库中的表结构不一致，则需要添加@Table注解和@Entity注解；如果不是，则不需要添加。
 * 4）如果字段中包含类型这种字段，需要添加一个对应类型的枚举，然后用枚举来赋值：如类型字段，需要
 * 扩展一个类型枚举 xxxType{ One= 1 ,Two =2 } 。
 */
class BaseDomain {

    @Id
    @Column(name = "id")
    private String id

    @Column(name = "work_id")
    private Long workId

    @Column(name = "creator_id")
    private String creatorId

    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createTime

    @Column(name = "modifier_id")
    private String modifierId

    @Column(name = "modify_time")
    private Timestamp modifyTime

    @Column(name = "deleted")
    private Boolean deleted = false

}

