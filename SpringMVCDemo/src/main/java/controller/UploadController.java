package controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/test/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IOException {
        String name = RandomStringUtils.randomAlphanumeric(10) + ".jpg";
        File newFile = new File(request.getServletContext().getRealPath("/img"), name);

        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);

        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", name);
        mav.addObject("imagePath", newFile.getPath());
        return mav;
    }
}
