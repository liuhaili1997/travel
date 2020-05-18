package co.xingguo.travelmanage.model;

import java.math.BigDecimal;

public class Reservation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.USER_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.VIEW_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private Long viewId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.VIEW_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private String viewName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.VIEW_PRICE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private BigDecimal viewPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.USER_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.EMAIL
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.PHONE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.CTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private Long ctime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RESERVATION.UTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    private Long utime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.ID
     *
     * @return the value of RESERVATION.ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.ID
     *
     * @param id the value for RESERVATION.ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.USER_ID
     *
     * @return the value of RESERVATION.USER_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.USER_ID
     *
     * @param userId the value for RESERVATION.USER_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.VIEW_ID
     *
     * @return the value of RESERVATION.VIEW_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public Long getViewId() {
        return viewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.VIEW_ID
     *
     * @param viewId the value for RESERVATION.VIEW_ID
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setViewId(Long viewId) {
        this.viewId = viewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.VIEW_NAME
     *
     * @return the value of RESERVATION.VIEW_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.VIEW_NAME
     *
     * @param viewName the value for RESERVATION.VIEW_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setViewName(String viewName) {
        this.viewName = viewName == null ? null : viewName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.VIEW_PRICE
     *
     * @return the value of RESERVATION.VIEW_PRICE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public BigDecimal getViewPrice() {
        return viewPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.VIEW_PRICE
     *
     * @param viewPrice the value for RESERVATION.VIEW_PRICE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setViewPrice(BigDecimal viewPrice) {
        this.viewPrice = viewPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.USER_NAME
     *
     * @return the value of RESERVATION.USER_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.USER_NAME
     *
     * @param userName the value for RESERVATION.USER_NAME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.EMAIL
     *
     * @return the value of RESERVATION.EMAIL
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.EMAIL
     *
     * @param email the value for RESERVATION.EMAIL
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.PHONE
     *
     * @return the value of RESERVATION.PHONE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.PHONE
     *
     * @param phone the value for RESERVATION.PHONE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.CTIME
     *
     * @return the value of RESERVATION.CTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public Long getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.CTIME
     *
     * @param ctime the value for RESERVATION.CTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RESERVATION.UTIME
     *
     * @return the value of RESERVATION.UTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public Long getUtime() {
        return utime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RESERVATION.UTIME
     *
     * @param utime the value for RESERVATION.UTIME
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    public void setUtime(Long utime) {
        this.utime = utime;
    }
}