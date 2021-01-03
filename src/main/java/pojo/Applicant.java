package pojo;


public class Applicant {
    //求职者昵称
    private String applicantId;
    //求职者邮箱
    private String applicantEmail;
    //求职者密码
    private String applicantPwd;
    private String sex;
    private String location;
    private String business;
    private String phonenum;
    private String job;
    public Applicant(String applicantId,String applicantEmail,String applicantPwd,String sex,String location,String business,String phonenum,String job)
    {
        super();
        this.applicantId=applicantId;
        this.applicantEmail=applicantEmail;
        this.applicantPwd=applicantPwd;
        this.business=business;
        this.sex=sex;
        this.location=location;
        this.job=job;
        this.phonenum=phonenum;
    }
    public String getapplicantemail(){
        return applicantEmail;

    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getLocation() {
        return location;
    }

    public String getBusiness() {
        return business;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getJob() {
        return job;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public String getApplicantId(){
        return applicantId;
    }
    public String getSex(){
        return sex;
    }
}
