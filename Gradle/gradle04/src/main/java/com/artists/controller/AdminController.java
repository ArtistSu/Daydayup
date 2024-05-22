
import com.artists.bean.Admin;
import com.artists.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Admin> getAdminList() {
        System.out.println("dada");
        return adminService.getAdminList();
    }

}
