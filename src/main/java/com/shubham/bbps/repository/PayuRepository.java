package com.shubham.bbps.repository;


import com.shubham.bbps.model.PayuModal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayuRepository extends JpaRepository<PayuModal, Long> {
  @Query("SELECT u FROM PayuModal u WHERE u.rfid = :rfid and u.amountpaid is null")
  PayuModal fetchReceiptbyRfid(@Param("rfid") String paramString);
  
  @Query("SELECT u FROM PayuModal u WHERE u.rfid = :rfid and billNumber=:billerTxnId")
  PayuModal fetchPaymentstatus(@Param("rfid") String paramString1, @Param("billerTxnId") String paramString2);
  
  @Query("SELECT u FROM PayuModal u WHERE date(u.createdAt)>= ( CURDATE() - 2) and u.amountpaid is not NULL AND u.loanaccountppnumber=:loannumber AND u.dueDate=:billDate order by u.createdAt desc")
  List<PayuModal> isAlreadyPaidLast2Days(@Param("loannumber") String paramString1, @Param("billDate") String paramString2);
}
