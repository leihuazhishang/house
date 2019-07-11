import com.kgc.controller.DistrictController;
import com.kgc.mapper.DistrictMapper;
import com.kgc.service.impl.DistrictServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        DistrictController districtServiceImpl = (DistrictController) applicationContext.getBean("districtController");
        System.out.println(districtServiceImpl.selectAll(1,3));
    }
}
