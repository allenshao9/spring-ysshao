package com.amarsoft.ysshao.creditinfo.entity;/**
 * @author ysshao
 * @create 2020-09-11 23:08
 */
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @Author AllenShao
 * @Description TODO
 * @Date 2020/9/11 23:08
 * @Version 1.0
 **/

@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "CreditInfo") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@Data
@ToString
@SequenceGenerator(name="creditseq", sequenceName="CreditInfo_SEQ",allocationSize = 1)
public class CreditInfo implements Serializable {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="creditseq")//自增主键
    private long serialno;
    @Column
    private String customerid;

    @Column
    private String customername;

    @Column
    private String loantype;

    @Column
    private Double businesssum;

    @Column(length = 20)
    private String certtype;
    @Column(length = 20)
    private String certid;

}
