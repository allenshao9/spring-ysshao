package com.amarsoft.ysshao.springbootdatajpa.repository;

import com.amarsoft.ysshao.springbootdatajpa.entities.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
// CrudRepository 可以完成普通的crud
//PagingAndSortingRepository   可以实现分页、排序
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo,Integer> {

    //定义查询内容。 使用certid字段查询
    CustomerInfo findCustomerInfoByCertid(String string);

    //使用Query注解进行开发  可以用
    @Query(value="  from CustomerInfo  where customername =:customername ")
    CustomerInfo queryCustomerNameJPQL(String customername );


    //查询不到结果。。。 未知原因？？？？
    @Query(value="  from CustomerInfo  where certtype like :certtype ")
    List<CustomerInfo> queryCertTypeJPQL(String certtype );

    // Containing 即包含。 相当于 like %certid%
    List<CustomerInfo> findCustomerByCerttypeContaining(String certtype);


    //使用原生SQL查询
    @Query(value= "select * from customerinfo where customername= ? ",nativeQuery=true)
    List<CustomerInfo> queryCustomerInfo(String customername);

    //Update 同样可以使用Query进行操作


}
