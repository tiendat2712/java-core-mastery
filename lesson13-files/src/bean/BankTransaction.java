package bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankTransaction {

    private String from; // người chuyển
    private String to; // người nhận
    private BigDecimal totalOfMoney;
    private LocalDateTime sendingTime;
    private Boolean isSuccess;

    public BankTransaction() {
    }

    public BankTransaction(String from, String to, BigDecimal totalOfMoney, LocalDateTime sendingTime,
                           Boolean isSuccess) {
        this.from = from;
        this.to = to;
        this.totalOfMoney = totalOfMoney;
        this.sendingTime = sendingTime;
        this.isSuccess = isSuccess;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getTotalOfMoney() {
        return totalOfMoney;
    }

    public void setTotalOfMoney(BigDecimal totalOfMoney) {
        this.totalOfMoney = totalOfMoney;
    }

    public LocalDateTime getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(LocalDateTime sendingTime) {
        this.sendingTime = sendingTime;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "BankTransaction [from=" + from + ", to=" + to + ", totalOfMoney=" + totalOfMoney + ", sendingTime="
                + sendingTime + ", isSuccess=" + isSuccess + "]";
    }

}