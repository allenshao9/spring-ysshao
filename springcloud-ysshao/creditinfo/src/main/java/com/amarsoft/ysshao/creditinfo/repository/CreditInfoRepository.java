package com.amarsoft.ysshao.creditinfo.repository;

import com.amarsoft.ysshao.creditinfo.entity.CreditInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//继承JpaRepository来完成对数据库的操作
// CrudRepository 可以完成普通的crud
//PagingAndSortingRepository   可以实现分页、排序
public interface CreditInfoRepository extends JpaRepository<CreditInfo,Long> {

    //使用原生SQL查询
    @Query(value= "select * from CreditInfo where customerid= ? ",nativeQuery=true)
    List<CreditInfo> queryCreditInfo(String  customerid);

}
