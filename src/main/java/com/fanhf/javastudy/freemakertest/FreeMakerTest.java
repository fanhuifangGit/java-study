package com.fanhf.javastudy.freemakertest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author fanhf
 * @Description freemaker小demo：https://www.cnblogs.com/itdragon/p/7750903.html
 * @date 2020-11-14 20:31
 */
@Slf4j
public class FreeMakerTest {

   public  static void main(String[] args) throws IOException, TemplateException {
       FreeMakerTest freeMakerTest = new FreeMakerTest();
//       freeMakerTest.nameWord();

//       ConstructionBean constructionBean1 = freeMakerTest.cons1();
//       ConstructionBean constructionBean2 = freeMakerTest.cons2();
//       freeMakerTest.constructionExcel(constructionBean1,3);
//       freeMakerTest.constructionExcel(constructionBean2,4);

       ResumeBean resumeBean =  freeMakerTest.resume();
//       freeMakerTest.resumeTemplate(resumeBean,1);
       freeMakerTest.resumeTemplate(resumeBean,2);
   }

    public  void nameWord() throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是freemarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 第二步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
        // 第三步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();
        //向数据集中添加数据
        dataModel.put("name", "this is my first freemarker test.");
        // 第四步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Template template = null;
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/study/java/name/name.doc"), "UTF-8"));){
            // 第五步：设置模板文件所在的路径。
            configuration.setClassForTemplateLoading(this.getClass(), "/templates");
            //文件名，获取模板
            template = configuration.getTemplate("name.ftl");
            // 第六步：调用模板对象的process方法输出文件。
            template.process(dataModel, out);
            // 第七步：关闭流。
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void constructionExcel(ConstructionBean constructionBean,Integer type) throws IOException, TemplateException {
        //第一步，创建一个Configuration对象，直接new一个对象，构造方法的参数就是freemaker对应的版本号
        Configuration configuration = new Configuration(Configuration.getVersion());
        //第二步 设置模板文件使用的字符集，一般是U8
        configuration.setDefaultEncoding("utf-8");
        //第三步 创建一个模板中使用的数据的对象，将对象存到map
        Map map = new HashMap<>();
        //第四步 向数据集中添加数据
        map.put("constructionBeans",constructionBean);
        //第五步 数据准备好，模板准备好，就准备开始写文件
        Template template = null;
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/study/java/name/construction"+type+".docx")))){
            configuration.setClassForTemplateLoading(this.getClass(),"/templates");
            //文件名，获取模板
            template = configuration.getTemplate("construction.ftl");
            //第六步 调用模板对象的process方法输出文件
            template.process(map,out);
            //第七步 关闭流
            out.close();
            log.info("生成文档结束......");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void resumeTemplate(ResumeBean resumeBean,Integer type){
       Configuration configuration = new Configuration(Configuration.getVersion());
       configuration.setDefaultEncoding("utf-8");

       Map map = new HashMap();
       map.put("resumeBean",resumeBean);

       Template template = null;
       try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/study/java/name/resume"+type+".docx")))) {
           configuration.setClassForTemplateLoading(this.getClass(),"/templates");
           template = configuration.getTemplate("resume.ftl");
           template.process(map,out);
           out.close();
           log.info("简历生成结束");
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public ConstructionBean cons1(){
        ConstructionBean constructionBean1 = new ConstructionBean();
        constructionBean1.setCompanyName("小熊猫网络科技有限公司");
        constructionBean1.setProjectName("基础建设");
        constructionBean1.setPorjectContent("搭建光纤的万兆宽带");
        constructionBean1.setBuildingArea(1000);
        constructionBean1.setBuildingLocation("北京市海淀区盈科大厦");
        constructionBean1.setStucturalStyle("上九天揽月，下五洋捉鳖");
        constructionBean1.setBuildingFloor(20000);
        constructionBean1.setTotalMoney(2000000.99);
        constructionBean1.setEveryMoney(20000.89);
        constructionBean1.setDirectFee(30000.9D);
        constructionBean1.setIndirectFee(30000.701);
        constructionBean1.setMaterialDiffPrice(50000.0D);
        constructionBean1.setOtherFee(4000.0D);
        constructionBean1.setStartWorkTime("2020-12-01");
        constructionBean1.setFinishedWorkTime("2120-12-30");
        constructionBean1.setTotalDays(100*12*30);
        constructionBean1.setArrivalLevel(1);
        constructionBean1.setQualityGuarantee("保持100年无故障");
        constructionBean1.setConstructionMaterial("光纤材料，钢材，铝合金");

        return constructionBean1;
    }

    public ConstructionBean cons2(){
        ConstructionBean constructionBean2 = new ConstructionBean();
        constructionBean2.setCompanyName("华鼎科技有限公司");
        constructionBean2.setProjectName("网络建设");
        constructionBean2.setPorjectContent("搭建光纤的万兆宽带");
        constructionBean2.setBuildingArea(1000);
        constructionBean2.setBuildingLocation("北京市海淀区中鼎大厦");
        constructionBean2.setStucturalStyle("上达天听");
        constructionBean2.setBuildingFloor(10000);
        constructionBean2.setTotalMoney(1000000.99);
        constructionBean2.setEveryMoney(10000.89);
        constructionBean2.setDirectFee(30000.9D);
        constructionBean2.setIndirectFee(20000.701);
        constructionBean2.setMaterialDiffPrice(10000.0D);
        constructionBean2.setOtherFee(1000.0D);
        constructionBean2.setStartWorkTime("2020-12-01");
        constructionBean2.setFinishedWorkTime("2050-12-30");
        constructionBean2.setTotalDays(30*12*30);
        constructionBean2.setArrivalLevel(1);
        constructionBean2.setQualityGuarantee("保持50年无故障");
        constructionBean2.setConstructionMaterial("光纤材料，钢材，铝合金");
        return constructionBean2;
    }

    public  ResumeBean resume(){
        ResumeBean resumeBean =  new ResumeBean();
        resumeBean.setBirthDay("2000月1月1日");
        resumeBean.setTel("15894663826");
        resumeBean.setPlaceOfBirth("河南商丘");
        resumeBean.setEmail("2424045058@qq.com");
        resumeBean.setEduLevel("本科");
        resumeBean.setLivesAddress("北京海淀区");
        resumeBean.setEduTime("2012.09-2016.06");
        resumeBean.setColloege("广州大学/营销学院");
        resumeBean.setMajor("市场营销");
        resumeBean.setClassInfo("国际市场营销、国际市场营销、市场调查与预测、大学心理学、商业心理学、公共关系学、经济法国际贸易、大学英语、计算机应用");
        resumeBean.setJobExpericeTime("2014.07-2017.08");
        resumeBean.setJobCompany("上海果果电子公司");
        resumeBean.setPosition("区域销售助理");
        resumeBean.setPositionDescribe1("1.自毕业起即加入上海果果电子公司，当时薪资3900元，负责公司唯一的零售门市零售业务;");
        resumeBean.setPositionDescribe2("2.春节后公司即调我回总部，参与公司主营业务，负责美的产品上海分销;　　　");
        resumeBean.setPositionDescribe3("3.全面熟悉公司全线产品的产品性能、价格及销售政策、竞争对手产品调查等各项工作。　");
        resumeBean.setLanguageSkills("通过大学英语CET6、普通话一级甲等");
        resumeBean.setProfessionalSkills("熟练掌握销售各种技巧，熟练公司商务流程");
        resumeBean.setOfficeSkills("通过计算机等级考试（二级C），熟练掌握Word、Excel、PPT等日常办公软件");
        resumeBean.setSelfAssessment("本人具备销售人员应具有的素质：积极，自信，大胆，开朗，沟通力强。专业的产品知识、谈话技巧、商务礼仪。成熟稳重，责任心强，心态稳定，敢于担当重任； 有一定的营销与管理经验，接受能力强，能迅速接受新的理论与技能。");

        return  resumeBean;

    }
}
