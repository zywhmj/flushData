package com.flush.data.module.entity;

import java.io.Serializable;

public class P2pMember implements Serializable {
    private Integer id;

    private String userName;

    private String userPhoto;

    private String userPass;

    private Byte userType;

    private String userEmail;

    private String userPhone;

    private Byte userLevel;

    private Integer levelActiveTime;

    private Integer degradeDays;

    private Long credits;

    private Long scores;

    private Integer regTime;

    private String regIp;

    private Integer recommendId;

    private String expandNum;

    private Long delicatedCustomer;

    private String platform;

    private String regFromSeo;

    private String userFrom;

    private String fadadaId;

    private Integer autoSignContractId;

    private Byte autoSignContract;

    private Integer borrowerAutoSignContractId;

    private String clientId;

    private String salt;

    private Integer usernameUpdateTime;

    private Integer freeWithdrawNum;

    private String channel;

    private String promote;

    private Integer planContractId;

    private String loanUserPhone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Byte getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getLevelActiveTime() {
        return levelActiveTime;
    }

    public void setLevelActiveTime(Integer levelActiveTime) {
        this.levelActiveTime = levelActiveTime;
    }

    public Integer getDegradeDays() {
        return degradeDays;
    }

    public void setDegradeDays(Integer degradeDays) {
        this.degradeDays = degradeDays;
    }

    public Long getCredits() {
        return credits;
    }

    public void setCredits(Long credits) {
        this.credits = credits;
    }

    public Long getScores() {
        return scores;
    }

    public void setScores(Long scores) {
        this.scores = scores;
    }

    public Integer getRegTime() {
        return regTime;
    }

    public void setRegTime(Integer regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public String getExpandNum() {
        return expandNum;
    }

    public void setExpandNum(String expandNum) {
        this.expandNum = expandNum == null ? null : expandNum.trim();
    }

    public Long getDelicatedCustomer() {
        return delicatedCustomer;
    }

    public void setDelicatedCustomer(Long delicatedCustomer) {
        this.delicatedCustomer = delicatedCustomer;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getRegFromSeo() {
        return regFromSeo;
    }

    public void setRegFromSeo(String regFromSeo) {
        this.regFromSeo = regFromSeo == null ? null : regFromSeo.trim();
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom == null ? null : userFrom.trim();
    }

    public String getFadadaId() {
        return fadadaId;
    }

    public void setFadadaId(String fadadaId) {
        this.fadadaId = fadadaId == null ? null : fadadaId.trim();
    }

    public Integer getAutoSignContractId() {
        return autoSignContractId;
    }

    public void setAutoSignContractId(Integer autoSignContractId) {
        this.autoSignContractId = autoSignContractId;
    }

    public Byte getAutoSignContract() {
        return autoSignContract;
    }

    public void setAutoSignContract(Byte autoSignContract) {
        this.autoSignContract = autoSignContract;
    }

    public Integer getBorrowerAutoSignContractId() {
        return borrowerAutoSignContractId;
    }

    public void setBorrowerAutoSignContractId(Integer borrowerAutoSignContractId) {
        this.borrowerAutoSignContractId = borrowerAutoSignContractId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getUsernameUpdateTime() {
        return usernameUpdateTime;
    }

    public void setUsernameUpdateTime(Integer usernameUpdateTime) {
        this.usernameUpdateTime = usernameUpdateTime;
    }

    public Integer getFreeWithdrawNum() {
        return freeWithdrawNum;
    }

    public void setFreeWithdrawNum(Integer freeWithdrawNum) {
        this.freeWithdrawNum = freeWithdrawNum;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getPromote() {
        return promote;
    }

    public void setPromote(String promote) {
        this.promote = promote == null ? null : promote.trim();
    }

    public Integer getPlanContractId() {
        return planContractId;
    }

    public void setPlanContractId(Integer planContractId) {
        this.planContractId = planContractId;
    }

    public String getLoanUserPhone() {
        return loanUserPhone;
    }

    public void setLoanUserPhone(String loanUserPhone) {
        this.loanUserPhone = loanUserPhone == null ? null : loanUserPhone.trim();
    }
}