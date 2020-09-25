package com.amarsoft.ysshao.springbootdatajpa.entities;/**
 * @author ysshao
 * @create 2020-09-11 23:08
 */
import lombok.Data;

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
@Table(name = "customerinfo") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
@Data
public class CustomerInfo implements Serializable {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.AUTO)//自增主键
    private Integer customerid;
    @Column
    private String customername;
    @Column(length = 20)
    private String certtype;
    @Column(length = 20)
    private String certid;

}
