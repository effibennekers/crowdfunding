package nl.ing.crowdfunding.domain.ing.common;

/**
 * Created by Hans on 12-11-2014.
 * <p/>
 * <p/>
 * {
 * "sourceProductId" : "...",
 * "sourceProductIdentification" : "...",
 * "targetProductId" : "...",
 * "targetProductIdentification" : "...",
 * "targetCodeType" : {
 * "code" : "...",
 * "label" : "..."
 * },
 * "targetCode" : "...",
 * "targetBICCode" : "...",
 * "targetCustomerName" : "...",
 * "amount" : {
 * "value" : ...,
 * "currency" : {
 * "code" : "...",
 * "label" : "..."
 * }
 * },
 * "commission" : {
 * "value" : ...,
 * "currency" : {
 * "code" : "...",
 * "label" : "..."
 * }
 * },
 * "executionDate" : {
 * "datetime" : "..."
 * },
 * "transferType" : {
 * "code" : "...",
 * "label" : "..."
 * },
 * "description" : "...",
 * "paymentReference" : "..."
 * }
 */
public class Transfer {

  private String fromAccount;
  private String toAccount;

  public Transfer(String fromAccount, String amount, String toAccount, String toName) {
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.toName = toName;
    this.amount = amount;
  }

  public String getFromAccount() {
    return fromAccount;
  }

  public void setFromAccount(String fromAccount) {
    this.fromAccount = fromAccount;
  }

  public String getToAccount() {
    return toAccount;
  }

  public void setToAccount(String toAccount) {
    this.toAccount = toAccount;
  }

  public String getToName() {
    return toName;
  }

  public void setToName(String toName) {
    this.toName = toName;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  private String toName;
  private String amount;


}
